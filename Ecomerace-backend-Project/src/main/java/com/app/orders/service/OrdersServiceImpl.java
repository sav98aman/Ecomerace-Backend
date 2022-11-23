package com.app.orders.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cart.dao.CartDao;
import com.app.currentUserSession.service.CurrentUserSessionServiceIml;
import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.UserException;
import com.app.model.Cart;
import com.app.model.CurrentUserSession;
import com.app.model.Orders;
import com.app.model.Product;
import com.app.model.User;
import com.app.orders.dao.OrderDao;
import com.app.user.dao.UserDao;
import com.app.user.service.UserServieImpl;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired 
	private CurrentUserSessionServiceIml currentuserserviceimpl;
	@Autowired
	private UserDao userdao;
	@Autowired
	private CartDao cartdao;
	
	@Override
	public List<Orders> creatingnewOrder(String uuid) throws CartException, UserException, CurrentUserSessionException {
		 CurrentUserSession currentusersession=currentuserserviceimpl.findCurrentUserSession(uuid);
		 User user =userdao.findById(currentusersession.getUser_id()).get();
		 List<Cart> lisofcart=cartdao.findByUser(user);
		 
		if (lisofcart == null) {
			throw new CartException(" Cart Is Empty let Sphopinf First ");
		}
		 List<Product> listOfProduct=new ArrayList<>();
		 for (Cart cart2 : lisofcart) {
//			listOfProduct.add(cart2.getProduct());//adding all cart product to List of Product
			 Orders orders=new Orders();
			 orders.setProduct(cart2.getProduct());
			 orders.setUser(user);
			 orders.setOrder_date(LocalDate.now());
			 orders.setOrder_status(false);
			 orders.setPayment_status(false); 
			 orderDao.save(orders); 
		 }
		 
		 
		 
		 return findTheListOfOrders(uuid);
		 
	}

	@Override
	public List<Orders> findTheListOfOrders(String uuid)
			throws CartException, UserException, CurrentUserSessionException {
		// TODO Auto-generated method stub
		CurrentUserSession currentusersession=currentuserserviceimpl.findCurrentUserSession(uuid);
		User user =userdao.findById(currentusersession.getUser_id()).get();
		
		return orderDao.findByUser(user);
	}

}
