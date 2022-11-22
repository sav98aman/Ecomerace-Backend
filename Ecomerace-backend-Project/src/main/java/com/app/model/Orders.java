package com.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="oder_id")
	private Integer order_id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> product=new ArrayList<>();
	
	
	@Column(name = "order_date")
	private LocalDate order_date;
	
	@Column(name = "delivery_date")
	private LocalDate delivery_date;
	
	@Column(name = "order_status")
	private Boolean order_status;
	
	@Column(name = "payment_status")
	private Boolean payment_status;
	
	
	
	
}
