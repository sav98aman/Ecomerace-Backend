package com.app.admin.service;

import com.app.exception.AdminException;
import com.app.model.Admin;

public interface AdminService {
	
	public Admin registerNewAdmin(Admin admin)throws AdminException;
}
