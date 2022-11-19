package com.app.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.category.dao.CategoryDao;
import com.app.exception.CategoryException;
import com.app.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public Category addNewCategory(Category category) throws CategoryException {
		// TODO Auto-generated method stub
		Category isExitsCategory=categoryDao.findByCategoryName(category.getCategoryName());
		if (isExitsCategory != null) {
			throw new CategoryException("Category Is All reday Exits ");
			
		}
		return categoryDao.save(category);
	}
	@Override
	public String removeCategory(Integer category_id) throws CategoryException {
		Category isCategory=(categoryDao.findById(category_id).get());
		if (isCategory == null) {
			throw new CategoryException(category_id +" This Category Id Is Not Avilable ");
		}
		categoryDao.delete(isCategory);
		return "This Category Is Deleted "+isCategory.toString();
	}
	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

}
