package com.app.category.service;

import java.util.List;

import com.app.exception.CategoryException;
import com.app.exception.CurrentUserSessionException;
import com.app.model.Category;

public interface CategoryService {
	
	public Category addNewCategory(String uuid,Category category)throws CategoryException,CurrentUserSessionException;
	public String removeCategory(String uuid,Integer category_id)throws CategoryException,CurrentUserSessionException;
	public List<Category> viewAllCategory()throws CategoryException;
}
