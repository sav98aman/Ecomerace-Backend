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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer product_id;
	
	@Column(name = "productName")
	private String ProductName;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "seller_id")
	private Seller seller;
	
	@Column(name="sale_price")
	private Double sale_price;
	
	@Column(name="market_price")
	private Double market_price;
	
	
	@Column(name="feedback")
	private Feedback feedback;
}
