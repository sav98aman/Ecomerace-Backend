package com.app.cart.service;

import java.util.List;

import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.ProductException;
import com.app.model.Cart;


public interface CartService {

		public Cart addtoCart(String uuid,Integer prod_id,Integer qyt)throws CartException,ProductException,CurrentUserSessionException;

		public List<Cart> findListOfCart(String uuid)throws CartException,CurrentUserSessionException;
		
		public Cart removeCartList(String uuid,Integer cart_id)throws CartException,CurrentUserSessionException,ProductException;
}
