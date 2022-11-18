package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	/*
	 * feedback table
	 * 			+--------------------+--------------+------+-----+---------+-------+
				| Field              | Type         | Null | Key | Default | Extra |
				+--------------------+--------------+------+-----+---------+-------+
				| feedback_id        | int          | NO   | PRI | NULL    |       |
				| descrp             | varchar(255) | YES  |     | NULL    |       |
				| rating             | double       | YES  |     | NULL    |       |
				| product_product_id | int          | YES  | MUL | NULL    |       |
				+--------------------+--------------+------+-----+---------+-------+
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feedback_id")
	private Integer feedback_id;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name="descrp")
	private String decrp;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
}
