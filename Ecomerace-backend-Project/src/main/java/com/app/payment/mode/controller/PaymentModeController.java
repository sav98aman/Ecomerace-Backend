package com.app.payment.mode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CurrentUserSessionException;
import com.app.exception.PaymentModeException;
import com.app.model.PaymentMode;
import com.app.payment.mode.service.PaymentModeServiceImpl;
import com.app.payment.service.PaymentServiceImpl;

@RestController
@RequestMapping(value = "/payment")
public class PaymentModeController {

	@Autowired
	private PaymentModeServiceImpl paymentModeServicImpl;
	
	@PostMapping(value = "/addmode/{uuid}/{mode}")
	public ResponseEntity<PaymentMode> create_New_Payment_Mode(@PathVariable String uuid,@PathVariable String mode ) throws PaymentModeException, CurrentUserSessionException{
		return new ResponseEntity<PaymentMode>(paymentModeServicImpl.createNewpaymenMode(uuid, mode),HttpStatus.CREATED);
	}
}
