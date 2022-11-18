package com.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private Integer payment_id;
	
	@Column(name = "order_id")
	private Order order; 
	
	
	@Column(name="payment_mode_id")
	private PaymentMode payment_mode;
	
	@Column(name ="payment_status")
	private Boolean payment_status;
	
	
}
