package com.app.category.service;

import java.util.List;

import com.app.exception.CategoryException;
import com.app.model.Category;

public interface CategoryService {
	
	public Category addNewCategory(Category category)throws CategoryException;
	public String removeCategory(Integer category_id)throws CategoryException;
	public List<Category> viewAllCategory()throws CategoryException;
}
