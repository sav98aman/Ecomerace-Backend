package com.app.orders.service;

import java.util.List;

import javax.persistence.criteria.Order;

import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.Cart;
import com.app.model.Orders;

public interface OrdersService {

	//order through cart
	public List<Orders> creatingnewOrder(String uuid)throws CartException,UserException,CurrentUserSessionException;
	public List<Orders> findTheListOfOrders(String uuid) throws CartException,UserException,CurrentUserSessionException;
}
