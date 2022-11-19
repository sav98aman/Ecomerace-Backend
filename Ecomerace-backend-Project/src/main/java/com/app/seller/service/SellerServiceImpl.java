package com.app.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.SellerException;
import com.app.model.Seller;
import com.app.seller.dao.SellerDao;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao sellerDao;
	
	
	@Override
	public Seller creatingNewSeller(Seller seller) throws SellerException {
		// TODO Auto-generated method stub
		Seller isSeller=sellerDao.findBySeller_Mobile(seller.getSeller_Mobile());
		if (isSeller != null) {
			throw new SellerException(" Seller Is All reday Register ");
		}
		
		return sellerDao.save(seller);
	}

}
