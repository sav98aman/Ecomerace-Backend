package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private Integer payment_id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentMode paymentMode;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders> order=new ArrayList<>();
	
	@Column(name ="total_amt")
	private Double totalAmount;
	private Boolean payment_Status;
	
}
