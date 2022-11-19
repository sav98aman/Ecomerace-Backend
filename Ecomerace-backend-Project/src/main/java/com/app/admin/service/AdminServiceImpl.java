package com.app.admin.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.admin.Dao.AdminDao;
import com.app.currentUserSession.dao.CurrentUserDao;
import com.app.exception.AdminException;
import com.app.exception.CurrentUserSessionException;
import com.app.model.Admin;
import com.app.model.CurrentUserSession;
import com.app.model.dto.AdminDTO;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	@Autowired 
	private CurrentUserDao curruserDao;
	
	@Override
	public Admin registerNewAdmin(Admin admin) throws AdminException {
		Admin allreadyAdminByEmail=null;
		Admin allreadyAdminByMobile=null;
		allreadyAdminByEmail=adminDao.findByEmail(admin.getEmail());
		allreadyAdminByMobile=adminDao.findByMobile(admin.getMobile());
		/*
		 * check mobile number and Email is already Register or Not 
		 * if register then throw massage Login Please
		 * other Wise register New User
		 */
		if (allreadyAdminByMobile != null && allreadyAdminByEmail !=null) {
			throw new AdminException(" Mobile Number And Email Are Allready Register \nplease Login !");
		}
		if (allreadyAdminByMobile != null) {
			throw new AdminException(" Mobile Number is Allready Register \nPlease Login !");
		}
		if (allreadyAdminByEmail != null) {
			throw new AdminException(" Email Id is Allready Register \nPlease Login !");
		}
		// register New User 
		return adminDao.save(admin);
	}

	
	@Override
	public CurrentUserSession adminLogin(AdminDTO admindto) throws AdminException, CurrentUserSessionException {
		Admin IsAvilable=adminDao.findByMobile(admindto.getMobileNo());
		if (IsAvilable == null) {
			throw new AdminException(" Mobile Number Is Not Register Please Register First ");
		}
		
		CurrentUserSession currentusersession=null;
		currentusersession=curruserDao.findByUser_id(IsAvilable.getAdmin_id());
		if (currentusersession != null) {
			throw new CurrentUserSessionException(" Admin Is Already Login ");
		}
		
		if( !(IsAvilable.getPassword()).equals(admindto.getPassword()) ) {
			throw new AdminException(" Password Is Worng Please Enter Valid Passowrd");
		}
		currentusersession=new CurrentUserSession();
		String key= RandomString.make(6);
		currentusersession.setIslogin(true);
		currentusersession.setTimestamp(LocalDateTime.now());
		currentusersession.setUser_id(IsAvilable.getAdmin_id());
		currentusersession.setUuid(key);
		
		return curruserDao.save(currentusersession);
	}


	@Override
	public Boolean checkLogin(String uuid){
		CurrentUserSession currentUserSession=curruserDao.findByUuid(uuid);
		/*
		 * false--means Admin is not login
		 * true -- means Admin is login
		 */
		if (currentUserSession == null) {
			return false;
		}else {
			return true;
		}
		
	}


	@Override
	public String adminLogut(String uuid) throws CurrentUserSessionException {
		if(!checkLogin(uuid)) {
			throw new CurrentUserSessionException(" Admin Is Not Login ");
		}
		curruserDao.delete(findCurrentUserSession(uuid));
		return "Logout Succesfully !";
	}


	@Override
	public CurrentUserSession findCurrentUserSession(String uuid) throws CurrentUserSessionException {
		// TODO Auto-generated method stub
		if(!checkLogin(uuid)) {
			throw new CurrentUserSessionException(" Admin Is Not Login ");
		}
		CurrentUserSession iscurrentUserLogin=curruserDao.findByUuid(uuid);
		return iscurrentUserLogin;
	}

}
