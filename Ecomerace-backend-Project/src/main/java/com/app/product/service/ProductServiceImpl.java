package com.app.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.admin.service.AdminServiceImpl;
import com.app.category.dao.CategoryDao;
import com.app.exception.AdminException;
import com.app.exception.CategoryException;
import com.app.exception.ProductException;
import com.app.exception.SellerException;
import com.app.model.Category;
import com.app.model.Product;
import com.app.model.Seller;
import com.app.model.dto.ProductDto;
import com.app.product.Dao.ProductDao;
import com.app.seller.dao.SellerDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao proDao;
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SellerDao sellerdao;
	
	@Autowired
	private AdminServiceImpl adminserviceImpl;

	@Override
	public Product addNewProducts(String uuid, ProductDto productdto) throws ProductException, AdminException, SellerException, CategoryException {
		// TODO Auto-generated method stub
		if(!adminserviceImpl.checkLogin(uuid)){
			throw new AdminException("ADmin is Not Login Please Login First ");
		}
		
		Optional<Seller> optSeller=sellerdao.findById(productdto.getSeller_seller_id());
		if(optSeller.isEmpty()) {
			throw new SellerException("Seller Id Is Not Vaild Please Check Seller ID " +productdto.getSeller_seller_id());
		}
		Optional<Category> optcategory =categoryDao.findById(productdto.getCategory_category_id());
		if(optcategory.isEmpty()) {
			throw new SellerException("Category  Id Is Not Vaild Please Check category ID " +productdto.getCategory_category_id());
		}
		
		Product newProduct=new Product();
		newProduct.setBrand(productdto.getBrand());
		newProduct.setCategory(optcategory.get());
		newProduct.setFeedback(null);
		newProduct.setMarket_price(productdto.getMarket_price());
		newProduct.setProductName(productdto.getProduct_name());
		newProduct.setQuantity(productdto.getQuantity());
		newProduct.setSale_price(productdto.getSale_price());
		newProduct.setSeller(optSeller.get());
		
		return proDao.save(newProduct);
	}

	@Override
	public String removeproducts(String uuid, Integer product_id) throws ProductException, AdminException {
		if(!adminserviceImpl.checkLogin(uuid)){
			throw new AdminException("ADmin is Not Login Please Login First ");
		}
		
		Product Isproduct=viewProductByid(product_id);
		proDao.deleteById(product_id);
		
		return Isproduct.toString();
		
	}

	@Override
	public List<Product> viewALlProducts() throws ProductException {
		
		return proDao.findAll();
	}

	@Override
	public List<Product> viewProductByName(String prod_name) throws ProductException {
		List<Product> allproductbName=proDao.findByProductName(prod_name);
		return allproductbName;
	}

	@Override
	public Product viewProductByid(Integer prod_id) throws ProductException {
		Optional<Product> optProduct=proDao.findById(prod_id);
		if(optProduct.isEmpty()) {
			throw new ProductException(" Product Is not Present "+prod_id);
		}
		return optProduct.get();
	}
	
	
	
	

}
