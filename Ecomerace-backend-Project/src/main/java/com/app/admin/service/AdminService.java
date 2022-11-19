package com.app.admin.service;

import com.app.exception.AdminException;
import com.app.exception.CurrentUserSessionException;
import com.app.model.Admin;
import com.app.model.CurrentUserSession;
import com.app.model.dto.AdminDTO;

public interface AdminService {
	
	public Admin registerNewAdmin(Admin admin)throws AdminException;
	
	public CurrentUserSession adminLogin(AdminDTO admindto)throws AdminException,CurrentUserSessionException;
	public Boolean checkLogin(String uuid);
	public CurrentUserSession findCurrentUserSession(String uuid)throws CurrentUserSessionException;
	public String adminLogut(String uuid)throws CurrentUserSessionException;
}
