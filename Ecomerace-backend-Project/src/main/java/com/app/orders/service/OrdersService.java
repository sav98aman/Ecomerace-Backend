package com.app.orders.service;

import javax.persistence.criteria.Order;

import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.Cart;
import com.app.model.Orders;

public interface OrdersService {

	//order through cart
	public Orders creatingnewOrder(String uuid,Cart cart)throws CartException,UserException,CurrentUserSessionException;
}
