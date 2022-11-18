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
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private Integer admin_id;
	@Column(name = "firstName")
	private String fName;
	@Column(name = "lastName")
	private String lName;
	@Column(name = "email")
	private String email;
	@Column(name = "mobileno")
	private String mobile;
	@Column(name = "password")
	private String password;
	
}
