package com.app.payment.mode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.PaymentMode;

@Repository
public interface PaymentModeDao extends JpaRepository<PaymentMode, Integer>{
	
	@Query("SELECT p FROM PaymentMode p WHERE p.paymentModeName=:1")
	public PaymentMode findByPaymentModeName(String paymentModeName);
}
