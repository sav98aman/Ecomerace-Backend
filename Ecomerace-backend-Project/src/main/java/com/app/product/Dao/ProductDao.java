package com.app.product.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Product;
import com.app.model.Seller;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
	
//	public Product findByProductName(String productName);
	
	public List<Product> findBySeller(Seller seller);
		
	@Query("SELECT p FROM Product p WHERE p.ProductName=?1")
	public List<Product> findByProductName(String productName);
}
