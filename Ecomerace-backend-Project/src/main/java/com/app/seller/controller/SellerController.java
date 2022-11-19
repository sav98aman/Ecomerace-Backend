package com.app.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.exception.SellerException;
import com.app.model.Seller;
import com.app.seller.service.SellerServiceImpl;

@Repository
@RequestMapping(value = "/seller")
public class SellerController {
	
	@Autowired
	private SellerServiceImpl sellerserviceimpl;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Seller> Register_new_Seller_Handaller(@RequestBody Seller seller) throws SellerException{
		
		return new ResponseEntity<Seller>(sellerserviceimpl.creatingNewSeller(seller),HttpStatus.CREATED);
	}
}
