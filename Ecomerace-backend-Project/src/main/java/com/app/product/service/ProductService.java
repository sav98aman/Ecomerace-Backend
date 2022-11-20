package com.app.product.service;

import java.util.List;

import com.app.exception.AdminException;
import com.app.exception.CategoryException;
import com.app.exception.ProductException;
import com.app.exception.SellerException;
import com.app.model.Product;
import com.app.model.dto.ProductDto;

public interface ProductService {
	
	public Product addNewProducts(String uuid,ProductDto productdto)throws ProductException,AdminException,SellerException,CategoryException;
	public String removeproducts(String uuid,Integer product_id)throws ProductException,AdminException;
	public List<Product> viewALlProducts()throws ProductException;
	public List<Product> viewProductByName(String prod_name)throws ProductException;
	public Product viewProductByid(Integer prod_id)throws ProductException;
}
