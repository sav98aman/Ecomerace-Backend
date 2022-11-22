package com.app.orders.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Orders;

@RestController
public class OrderController {
	
	
	@PostMapping(value = "/order")
	public ResponseEntity<Orders> creating_Order(){
		Orders order=new Orders();
		return new ResponseEntity<Orders>(order,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
}
