package com.app.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.adminLevelDao.AdminDao;
import com.app.exception.AdminException;
import com.app.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
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
		if (allreadyAdminByMobile == null) {
			throw new AdminException(" Mobile Number is Allready Register \nPlease Login !");
		}
		if (allreadyAdminByEmail == null) {
			throw new AdminException(" Email Id is Allready Register \nPlease Login !");
		}
		// register New User 
		return adminDao.save(admin);
	}

}
