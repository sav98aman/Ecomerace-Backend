package com.app.currentUserSession.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.currentUserSession.dao.CurrentUserDao;
import com.app.exception.CurrentUserSessionException;
import com.app.model.CurrentUserSession;

@Service
public class CurrentUserSessionServiceIml implements CurrentUserSessionService {
	
	@Autowired
	private CurrentUserDao curssDao;
	
	@Override
	public CurrentUserSession findCurrentUserSession(String uuid) throws CurrentUserSessionException {
		CurrentUserSession currentUserSession=curssDao.findByUuid(uuid);
		if (currentUserSession == null) {
			throw new CurrentUserSessionException(" User Is Not Login ");
		}
		return currentUserSession;
	}
	
	@Override
	public Boolean checkUSerISLgoin(String uuid) throws CurrentUserSessionException {
		if(findCurrentUserSession(uuid)!=null) {
			return false;//not login
		}
		return true;//login true-->login account
	}
	
	
}
