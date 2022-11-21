package com.app.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

}
