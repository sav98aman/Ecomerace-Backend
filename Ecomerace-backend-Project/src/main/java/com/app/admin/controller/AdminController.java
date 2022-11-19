package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.admin.service.AdminServiceImpl;
import com.app.exception.AdminException;
import com.app.exception.CurrentUserSessionException;
import com.app.model.Admin;
import com.app.model.CurrentUserSession;
import com.app.model.dto.AdminDTO;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminserviceimpl;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Admin> Register_New_Admin_Handller(@RequestBody Admin admin) throws AdminException{
		Admin newAdmin=adminserviceimpl.registerNewAdmin(admin);
		return new ResponseEntity<Admin>(newAdmin,HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<CurrentUserSession> ADmin_Login_Handaller(@RequestBody AdminDTO admindto) throws AdminException, CurrentUserSessionException{
		CurrentUserSession newCurrentUserSeesion=adminserviceimpl.adminLogin(admindto);
		return new ResponseEntity<CurrentUserSession>(newCurrentUserSeesion,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/logout{uuid}")
	public ResponseEntity<String> ADmin_Logout_Handaller(@PathVariable String uuid) throws AdminException, CurrentUserSessionException{
		String res=adminserviceimpl.adminLogut(uuid);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
}
