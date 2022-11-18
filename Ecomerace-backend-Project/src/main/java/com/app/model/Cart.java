package com.app.model;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	private Integer cart_id;
	
	@Column(name = "user_id")
	private User user;
	
	@Column(name="product_id")
	private Product product;
}
