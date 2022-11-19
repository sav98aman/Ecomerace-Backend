package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.AdminException;
import com.app.exception.ProductException;
import com.app.model.Product;
import com.app.model.dto.ProductDto;
import com.app.product.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@PostMapping(value = "/add/{uuid}")
	public ResponseEntity<Product> Add_New_Product_Controller_Handlaler(@PathVariable String uuid,@RequestBody ProductDto product) throws ProductException, AdminException{
		Product newProduct=productserviceimpl.addNewProducts(uuid, product);
		
		return new ResponseEntity<Product>(newProduct,HttpStatus.ACCEPTED);
	}
}
