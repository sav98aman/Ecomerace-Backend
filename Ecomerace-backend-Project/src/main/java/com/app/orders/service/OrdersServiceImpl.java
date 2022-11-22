package com.app.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.Cart;
import com.app.model.Orders;
import com.app.orders.dao.OrderDao;
import com.app.user.service.UserServieImpl;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired 
	private UserServieImpl userserivceImpl;;
	
	@Override
	public Orders creatingnewOrder(String uuid, Cart cart) throws CartException, UserException, CurrentUserSessionException {
		
		if (cart == null) {
			throw new CartException(" Cart Is Empty let Sphopinf First ");
		}
		
		return null;
	}

}
