package com.app.payment.service;

import com.app.exception.CurrentUserSessionException;
import com.app.exception.PaymentException;
import com.app.exception.UserException;
import com.app.model.Payment;

public interface PaymentService {
	
	public Payment MakePayment(String uuid,Double amount)throws PaymentException,UserException,CurrentUserSessionException;
}
