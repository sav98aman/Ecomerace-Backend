package com.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.CurrentUserSession;
import com.app.model.User;
import com.app.model.dto.UserDTO;
import com.app.user.service.UserServieImpl;

@RestController
@RequestMapping(value = "user/")
public class UserController {
	
	@Autowired
	private UserServieImpl userservicimpl;
	
	@PostMapping(value = "/register")
	public ResponseEntity<User> register_New_User_Handaller(@RequestBody User user) throws UserException{
		return new ResponseEntity<User>(userservicimpl.registerNewUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/LogIn")
	public ResponseEntity<CurrentUserSession> Login_User_Handaller(@RequestBody UserDTO userdto) throws UserException, CurrentUserSessionException{
		return new ResponseEntity<CurrentUserSession>(userservicimpl.loginUser(userdto),HttpStatus.OK);
	}
	@PostMapping(value = "/logout/{uuid}")
	public ResponseEntity<String> LogOut_User_Handaller(@PathVariable String  uuid) throws UserException, CurrentUserSessionException{
		return new ResponseEntity<String>(userservicimpl.logoutUser(uuid),HttpStatus.OK);
		
	}
}
