package com.app.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.admin.service.AdminServiceImpl;
import com.app.exception.AdminException;
import com.app.model.Admin;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminserviceimpl;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Admin> RegisterNewAdmin(@RequestBody Admin admin) throws AdminException{
		Admin newAdmin=adminserviceimpl.registerNewAdmin(admin);
		return new ResponseEntity<Admin>(newAdmin,HttpStatus.CREATED);
	}
	
}
