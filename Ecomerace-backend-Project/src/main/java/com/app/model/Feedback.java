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
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_id")
	private Integer feedback_id;
	
	@Column(name = "product_id")
	private Product product;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name="descrp")
	private String decrp;
}
