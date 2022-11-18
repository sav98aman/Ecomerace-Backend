package com.app.model;

import java.time.LocalDate;

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
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private Integer order_id;
	
	@Column(name = "product_id")
	private Product product;
	
	@Column(name = "user_id")
	private User user;
	
	@Column(name = "order_date")
	private LocalDate order_date;
	
	@Column(name = "delivery_date")
	private LocalDate delivery_date;
	
	@Column(name = "order_status")
	private Boolean order_status;
	
	@Column(name = "payment_status")
	private Boolean payment_status;
}
