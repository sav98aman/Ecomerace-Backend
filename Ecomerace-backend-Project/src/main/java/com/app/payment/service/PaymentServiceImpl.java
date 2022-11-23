package com.app.payment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.currentUserSession.service.CurrentUserSessionServiceIml;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.PaymentException;
import com.app.exception.UserException;
import com.app.model.CurrentUserSession;
import com.app.model.Orders;
import com.app.model.Payment;
import com.app.model.User;
import com.app.orders.dao.OrderDao;
import com.app.payment.dao.PaymentDao;
import com.app.payment.mode.dao.PaymentModeDao;
import com.app.user.dao.UserDao;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentdao;
	
	@Autowired
	private CurrentUserSessionServiceIml currentuserserviceimpl;
	@Autowired
	private UserDao userdao;
	@Autowired
	private OrderDao orderdao;
	@Autowired
	private PaymentModeDao paymentmodedao;
	
	
	
	@Override
	public Payment MakePayment(String uuid, Double amount) throws PaymentException, UserException, CurrentUserSessionException {
		
	CurrentUserSession	IsCurrentUserseesion=currentuserserviceimpl.findCurrentUserSession(uuid);
	
	User user =userdao.findById(IsCurrentUserseesion.getUser_id()).get();
//	return user.toString();
	
	if(user==null) {
		throw new UserException(" Someting Worng Error ! ");
	}
	
	List<Orders> orders=orderdao.findByUser(user);
	double orderamout=0;
	for (Orders orders2 : orders) {
		
		orderamout+=orders2.getProduct().getSale_price();
		
		orders2.setDelivery_date(LocalDate.now().plusDays(7));
		orders2.setOrder_status(true);
		orders2.setPayment_status(true);

	}
	
	if(orderamout!=amount) {
		throw new PaymentException(" Please Make Payment "+orderamout);
	}
	
		Payment payment=new Payment();
		payment.setPaymentMode(paymentmodedao.findById(31).get());
		payment.setOrder(orders);
		payment.setPayment_Status(true);
		payment.setTotalAmount(orderamout);
		payment.setPaymentMode(null);
		
		
		return paymentdao.save(payment);
	
	
	}

}
