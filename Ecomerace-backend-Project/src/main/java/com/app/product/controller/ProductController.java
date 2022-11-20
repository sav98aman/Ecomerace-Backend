package com.app.product.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.AdminException;
import com.app.exception.CategoryException;
import com.app.exception.ProductException;
import com.app.exception.SellerException;
import com.app.model.Product;
import com.app.model.dto.ProductDto;
import com.app.product.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productserviceimpl;
	
	@PostMapping(value = "/add/{uuid}")
	public ResponseEntity<Product> Add_New_Product_Controller_Handlaler(@PathVariable String uuid,@RequestBody ProductDto product) throws ProductException, AdminException, SellerException, CategoryException{
		Product newProduct=productserviceimpl.addNewProducts(uuid, product);
		return new ResponseEntity<Product>(newProduct,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/viewAll/")
	public ResponseEntity<List<Product>> view_ALl_Product_Controller_Handlaler() throws ProductException{
		List<Product> allProduct=productserviceimpl.viewALlProducts();
		return new ResponseEntity<List<Product>>(allProduct,HttpStatus.OK);
	}
	
	@GetMapping(value = "/view/{productName}")
	public ResponseEntity<List<Product>> view_ALl_Product_by_Name_Controller_Handlaler(@PathVariable String productName) throws ProductException{
		List<Product> allProductByName=productserviceimpl.viewProductByName(productName);
		return new ResponseEntity<List<Product>>(allProductByName,HttpStatus.OK);
	}
	@GetMapping(value = "/view")
	public ResponseEntity<Product> view_ALl_Product_by_id_Controller_Handlaler(@PathParam(value = "prod_id") Integer prod_id) throws ProductException{
		Product allProductByName=productserviceimpl.viewProductByid(prod_id);
		return new ResponseEntity<Product>(allProductByName,HttpStatus.OK);
	}
}
