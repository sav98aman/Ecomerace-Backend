package com.app.orders.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Orders;
import com.app.model.User;
@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {
	
	public List<Orders> findByUser(User user);
}
