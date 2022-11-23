package com.app.payment.mode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.currentUserSession.service.CurrentUserSessionServiceIml;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.PaymentModeException;
import com.app.model.CurrentUserSession;
import com.app.model.PaymentMode;
import com.app.payment.mode.dao.PaymentModeDao;

@Service
public class PaymentModeServiceImpl implements PaymentModeService{

	@Autowired
	private PaymentModeDao paymentmodedao;
	
	@Autowired
	private CurrentUserSessionServiceIml currentuserservicimpl;
	

	@Override
	public PaymentMode createNewpaymenMode(String uuid,String ModeName) throws PaymentModeException, CurrentUserSessionException {
		CurrentUserSession currentuser=currentuserservicimpl.findCurrentUserSession(uuid);
		
		PaymentMode mode=new PaymentMode();
//		if (mode == null) {
//			throw new PaymentModeException(ModeName+ " THis Payment Mode Mode Name Is All reday Present ");
//		}
		mode.setPaymentModeName(ModeName);
		return paymentmodedao.save(mode);
	}
}
