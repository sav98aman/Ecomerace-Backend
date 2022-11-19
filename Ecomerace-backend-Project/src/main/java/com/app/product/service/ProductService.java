package com.app.product.service;

import com.app.exception.AdminException;
import com.app.exception.ProductException;
import com.app.model.Product;
import com.app.model.dto.ProductDto;

public interface ProductService {
	
	public Product addNewProducts(String uuid,ProductDto productdto)throws ProductException,AdminException;
}
