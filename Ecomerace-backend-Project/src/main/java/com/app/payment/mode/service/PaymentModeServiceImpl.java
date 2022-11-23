package com.app.payment.mode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.PaymentModeException;
import com.app.model.PaymentMode;
import com.app.payment.mode.dao.PaymentModeDao;

@Service
public class PaymentModeServiceImpl implements PaymentModeService{

	@Autowired
	private PaymentModeDao paymentmodedao;

	@Override
	public PaymentMode createNewpaymenMode(String ModeName) throws PaymentModeException {
//		paymentmodedao.findby
		return null;
	}
}
