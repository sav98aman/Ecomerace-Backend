package com.app.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.Cart;
import com.app.model.Orders;
import com.app.orders.service.OrdersServiceImpl;

@RestController
public class OrderController {
	
	@Autowired
	private OrdersServiceImpl orderserviceimpl;
	
	@PostMapping(value = "/order/{uuid}")
	public ResponseEntity<Orders> creating_Order(@PathVariable String uuid) throws CartException, UserException, CurrentUserSessionException{
		Orders order=orderserviceimpl.creatingnewOrder(uuid);
		return new ResponseEntity<Orders>(order,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/order/{uuid}")
	public ResponseEntity<List<Orders>> getting_all_b_USer_Order(@PathVariable String uuid) throws CartException, UserException, CurrentUserSessionException{
		List<Orders> order=orderserviceimpl.findTheListOfOrders(uuid);
		return new ResponseEntity<List<Orders>>(order,HttpStatus.OK);
	}
}
