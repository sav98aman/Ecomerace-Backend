package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
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
	
	@Column(name = "Quantity")
	private Integer Quantity;
	
	@Column(name = "brand")
	private String brand;
	
	@ManyToOne
	private Seller seller;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@Column(name="sale_price")
	private Double sale_price;
	
	@Column(name="market_price")
	private Double market_price;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
	private List<Feedback> feedback=new ArrayList<>();
	
	/*
	 * product table 
			+----------------------+--------------+------+-----+---------+-------+
			| Field                | Type         | Null | Key | Default | Extra |
			+----------------------+--------------+------+-----+---------+-------+
			| product_id           | int          | NO   | PRI | NULL    |       |
			| product_name         | varchar(255) | YES  |     | NULL    |       |
			| quantity             | int          | YES  |     | NULL    |       |
			| brand                | varchar(255) | YES  |     | NULL    |       |
			| market_price         | double       | YES  |     | NULL    |       |
			| sale_price           | double       | YES  |     | NULL    |       |
			| category_category_id | int          | YES  | MUL | NULL    |       |
			| seller_seller_id     | int          | YES  | MUL | NULL    |       |
			+----------------------+--------------+------+-----+---------+-------+
	 */
}