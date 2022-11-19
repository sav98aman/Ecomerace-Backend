package com.app.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.admin.service.AdminServiceImpl;
import com.app.exception.AdminException;
import com.app.exception.ProductException;
import com.app.model.Product;
import com.app.model.Seller;
import com.app.model.dto.ProductDto;
import com.app.product.Dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private AdminServiceImpl adminserviceImpl;
	
	@Override
	public Product addNewProducts(String uuid,ProductDto productdto) throws ProductException, AdminException {
		// TODO Auto-generated method stub
		if(!adminserviceImpl.checkLogin(uuid)){
			throw new AdminException("ADmin is Not Login Please Login First ");
		}
		
		return null;
	}

}
