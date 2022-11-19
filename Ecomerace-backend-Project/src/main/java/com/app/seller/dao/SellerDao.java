package com.app.seller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {
	
	@Query("SELECT s FROM Seller s WHERE s.seller_Mobile=?1")
	public Seller findBySeller_Mobile(String seller_Mobile);
}
