package com.app.seller.service;

import com.app.exception.SellerException;
import com.app.model.Seller;

public interface SellerService {
	
	public Seller creatingNewSeller(Seller seller)throws SellerException;
}
