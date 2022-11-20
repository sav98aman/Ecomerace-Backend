package com.app.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.admin.service.AdminServiceImpl;
import com.app.category.dao.CategoryDao;
import com.app.exception.CategoryException;
import com.app.exception.CurrentUserSessionException;
import com.app.model.Category;
import com.app.model.CurrentUserSession;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private AdminServiceImpl adminServiceIml;
	
	
	@Override
	public Category addNewCategory(String uuid,Category category) throws CategoryException,CurrentUserSessionException {
		// TODO Auto-generated method stub
		
		if(! adminServiceIml.checkLogin(uuid)) {
			throw new CurrentUserSessionException(" Admin Is Not Login Please Login First ");
		}
		
		Category isExitsCategory=categoryDao.findByCategoryName(category.getCategoryName());
		
		if (isExitsCategory != null) {
			throw new CategoryException("Category Is All reday Exits ");
			
		}
		return categoryDao.save(category);
	}
	@Override
	public String removeCategory(String uuid,Integer category_id) throws CategoryException, CurrentUserSessionException {
		if(! adminServiceIml.checkLogin(uuid)) {
			throw new CurrentUserSessionException(" Admin Is Not Login Please Login First ");
		}
		
		Category isCategory=(categoryDao.findById(category_id).get());
		if (isCategory == null) {
			throw new CategoryException(category_id +" This Category Id Is Not Avilable ");
		}
		categoryDao.delete(isCategory);
		return "This Category Is Deleted "+isCategory.toString();
	}
	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		return categoryDao.findAll();
	}

}
