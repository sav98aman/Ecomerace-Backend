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
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="seller_id")
	private Integer seller_id;
	
	@Column(name = "seller_Name")
	private String seller_Name;
	
	@Column(name = "Seller_Mobile")
	private String Seller_Mobile;
	
	@Column(name = "seller_address_id")
	private Address sellerAddress;
	
}
