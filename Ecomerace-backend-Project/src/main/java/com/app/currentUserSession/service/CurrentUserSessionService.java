package com.app.currentUserSession.service;

import com.app.exception.CurrentUserSessionException;
import com.app.model.CurrentUserSession;

public interface CurrentUserSessionService {
	
	public CurrentUserSession findCurrentUserSession(String uuid)throws CurrentUserSessionException;
	
	public Boolean checkUSerISLgoin(String uuid)throws CurrentUserSessionException;
}
