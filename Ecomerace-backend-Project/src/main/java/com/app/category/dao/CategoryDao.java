package com.app.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer>{
	
	@Query("SELECT c FROM Category c WHERE c.categoryName=?1")
	public Category findByCategoryName(String categoryName);
}
