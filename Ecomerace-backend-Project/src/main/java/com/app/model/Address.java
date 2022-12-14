package com.app.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	private String add1;
	private String add2;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
}
