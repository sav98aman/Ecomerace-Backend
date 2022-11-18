package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
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
	
	@Embedded
	@Column(name = "seller_address_id")
	private Address sellerAddress;
	/*
	 * one Seller can have many products
			+---------------+--------------+------+-----+---------+-------+
			| Field         | Type         | Null | Key | Default | Extra |
			+---------------+--------------+------+-----+---------+-------+
			| seller_id     | int          | NO   | PRI | NULL    |       |
			| seller_mobile | varchar(255) | YES  |     | NULL    |       |
			| add1          | varchar(255) | YES  |     | NULL    |       |
			| add2          | varchar(255) | YES  |     | NULL    |       |
			| city          | varchar(255) | YES  |     | NULL    |       |
			| mobile_no     | varchar(255) | YES  |     | NULL    |       |
			| pincode       | varchar(255) | YES  |     | NULL    |       |
			| state         | varchar(255) | YES  |     | NULL    |       |
			| seller_name   | varchar(255) | YES  |     | NULL    |       |
			+---------------+--------------+------+-----+---------+-------+
	 */
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Product> products=new ArrayList<>();
}
