package com.app.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CurrentUserSessionException;
import com.app.exception.PaymentException;
import com.app.exception.UserException;
import com.app.model.Payment;
import com.app.payment.service.PaymentServiceImpl;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentServiceImpl paymentserviceimpl;
	
	
	@PostMapping(value =  "/orders/{uuid}/{amt}")
	public ResponseEntity<Payment> Make_Payment_Handaller(@PathVariable String uuid,@PathVariable Double amt) throws PaymentException, UserException, CurrentUserSessionException{
		return new ResponseEntity<Payment>(paymentserviceimpl.MakePayment(uuid, amt),HttpStatus.ACCEPTED);
	}
	
	
}
