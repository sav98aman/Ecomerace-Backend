package com.app.currentUserSession.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.CurrentUserSession;

@Repository
public interface CurrentUserDao extends JpaRepository<CurrentUserSession, Integer> {
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.user_id=?1")
	public CurrentUserSession findByUser_id(Integer user_id);
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid=?1")
	public CurrentUserSession findByUuid(String uuid);
}
