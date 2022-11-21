package com.app.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Cart;
import com.app.model.Product;
import com.app.model.User;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
	
	public Cart findByProduct(Product product);
	
	public List<Cart> findByUser(User user);
}
