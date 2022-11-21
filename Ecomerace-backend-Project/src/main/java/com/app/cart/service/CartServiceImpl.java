package com.app.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.cart.dao.CartDao;
import com.app.currentUserSession.service.CurrentUserSessionServiceIml;
import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.ProductException;
import com.app.model.Cart;
import com.app.model.CurrentUserSession;
import com.app.model.Product;
import com.app.model.User;
import com.app.product.service.ProductServiceImpl;
import com.app.user.dao.UserDao;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartdao;
	@Autowired
	private CurrentUserSessionServiceIml currentUserimpl;
	@Autowired
	private ProductServiceImpl prodserimpl;
	@Autowired
	private UserDao userdao;
	
	@Override
	public Cart addtoCart(String uuid, Integer prod_id,Integer quaintity) throws CartException, ProductException, CurrentUserSessionException {
		CurrentUserSession currentUser=currentUserimpl.findCurrentUserSession(uuid);
		
		Product prod=prodserimpl.viewProductByid(prod_id);
		User user=(userdao.findById(currentUser.getUser_id())).get();
		
		List<Cart> list=findListOfCart(uuid);
		
		for(Cart cart : list) {
			if(cart.getProduct().equals(prod)) {
				throw new CartException(" This Item Is Allready Added In cart ");
			}
		}
		
		Cart cart=new Cart();
		if(prod.getQuantity()<quaintity) {
			throw new ProductException(prod.getQuantity()+ " Stock Is Avilable Only please Select valid Quantity ");
		}
		cart.setProduct(prod);
		cart.setUser(user);
		cart.setQyt(quaintity);
		
		
		return cartdao.save(cart);
	}

	
	
	@Override
	public List<Cart> findListOfCart(String uuid) throws CartException, CurrentUserSessionException {
		CurrentUserSession curretusersession=currentUserimpl.findCurrentUserSession(uuid);
		
		 List<Cart> listofCart=cartdao.findByUser((userdao.findById(curretusersession.getUser_id())).get());
		 if (listofCart == null) {
			 throw new CartException(" Cart Is Empty !");
		}
		return listofCart;
	}



	
	
	@Override
	public Cart removeCartList(String uuid, Integer cart_id) throws CartException, CurrentUserSessionException, ProductException {
		// TODO Auto-generated method stub
		CurrentUserSession curretusersession=currentUserimpl.findCurrentUserSession(uuid);
		User user=(userdao.findById(curretusersession.getUser_id())).get();
		List<Cart> list=findListOfCart(uuid);
		
		Cart Iscart=null;
		int count=0;
		for (Cart cart : list) {
			if(cart.getUser().equals(user) && cart.getCart_id().equals(cart_id)) {
				Iscart=cart;
				cartdao.delete(Iscart);
				count++;
			}
		}
		if(count>0) {
			return Iscart;
		}
		else {
			throw new CartException(cart_id+ " this cart ID Is Not Avilable With this user ");
		}
	}
	
	
	
	

}
