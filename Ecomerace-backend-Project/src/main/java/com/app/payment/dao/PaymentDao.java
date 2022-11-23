package com.app.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment,Integer>{
	
	
}
