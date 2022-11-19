package com.app.model.dto;

import lombok.Data;

@Data
public class ProductDto {
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
	private String product_name;
	private Integer quantity;
	private String brand ;
	private Double market_price;
	private Double sale_price;
	private Integer category_category_id;
	private Integer seller_seller_id;
}
