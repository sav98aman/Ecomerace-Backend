package com.app.user.service;

import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.model.dto.UserDTO;


public interface UserService {
		
	public User registerNewUser(User user)throws UserException;
	
	public CurrentUserSession loginUser(UserDTO userdto)throws UserException,CurrentUserSessionException;
	
	public String logoutUser(String uuid)throws UserException,CurrentUserSessionException;
}
