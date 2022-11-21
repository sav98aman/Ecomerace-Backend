package com.app.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cart.dao.CartDao;
import com.app.model.Cart;
import com.app.model.Product;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
	@Autowired
	private CartDao cartdao;
	
	@PostMapping(value = "/addTOcart")
	public ResponseEntity<List<Product>> add_new_cart(@RequestBody Cart cart){
		List<Product> list=new ArrayList<>();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
}
