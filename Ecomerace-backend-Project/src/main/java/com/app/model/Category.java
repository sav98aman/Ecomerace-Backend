package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
	/*
	 * categoryTable::
		 *  +---------------+--------------+------+-----+---------+-------+
			| Field         | Type         | Null | Key | Default | Extra |
			+---------------+--------------+------+-----+---------+-------+
			| category_id   | int          | NO   | PRI | NULL    |       |
			| category_name | varchar(255) | YES  |     | NULL    |       |
			+---------------+--------------+------+-----+---------+-------+
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="category_id")
	private Integer category_id;
	
	@Column(name="categoryName")
	private String categoryName;
	

}
