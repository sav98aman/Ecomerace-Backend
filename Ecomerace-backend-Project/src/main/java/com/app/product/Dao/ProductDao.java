package com.app.product.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Product;
import com.app.model.Seller;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
	
//	public Product findByProductName(String productName);
	
	public List<Product> findBySeller(Seller seller);
}
