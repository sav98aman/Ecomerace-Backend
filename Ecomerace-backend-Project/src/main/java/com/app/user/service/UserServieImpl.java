package com.app.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.currentUserSession.dao.CurrentUserDao;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.model.dto.UserDTO;
import com.app.user.dao.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServieImpl  implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CurrentUserDao currentuserDao;

	@Override
	public User registerNewUser(User user) throws UserException {
		// TODO Auto-generated method stub
		 User IsUser=userDao.findByMobile(user.getMobile());
		 if (IsUser != null) {
			 throw new UserException(" User Is ALready register ");
		 }
		 
		 
		 return userDao.save(user);
	}

	@Override
	public CurrentUserSession loginUser(UserDTO userdto) throws UserException, CurrentUserSessionException {
		User isUser=userDao.findByMobile(userdto.getMobileno());
		if (isUser == null) {
			throw new UserException("User IS No Register this mobile Number " +userdto.getMobileno());	
		}
		CurrentUserSession currentusersession= currentuserDao.findByUser_id(isUser.getUser_id());
		if (currentusersession!=null) {
			throw new CurrentUserSessionException(" User IS ALl ready Login ");
		}
		
		if(!isUser.getPassword().equals(userdto.getPassword())) {
			throw new UserException(" Password Is worng ");
		}
		currentusersession=new CurrentUserSession();
		String key= RandomString.make(6);
		currentusersession.setIslogin(true);
		currentusersession.setTimestamp(LocalDateTime.now());
		currentusersession.setUser_id(isUser.getUser_id());
		currentusersession.setUuid(key);
		
		
		
		return currentuserDao.save(currentusersession);
	}

	@Override
	public String logoutUser(String uuid) throws UserException, CurrentUserSessionException {
		CurrentUserSession currentusersession=currentuserDao.findByUuid(uuid);
		if (currentusersession==null) {
			throw new CurrentUserSessionException(" User IS Not  Login ");
		}
		currentuserDao.delete(currentusersession);
		return "Logout succesfully !";
	}
}
