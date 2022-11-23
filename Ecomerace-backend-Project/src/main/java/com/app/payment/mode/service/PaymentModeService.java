package com.app.payment.mode.service;

import com.app.exception.CurrentUserSessionException;
import com.app.exception.PaymentModeException;
import com.app.model.PaymentMode;

public interface PaymentModeService {

	public PaymentMode createNewpaymenMode(String uuid,String ModeName)throws PaymentModeException,CurrentUserSessionException;
}
