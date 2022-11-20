package com.app.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.category.service.CategoryServiceImpl;
import com.app.exception.CategoryException;
import com.app.exception.CurrentUserSessionException;
import com.app.model.Category;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryserviceimpl;
	
	@PostMapping(value = "/add/{uuid}")
	public ResponseEntity<Category> create_new_category_Handaller(@PathVariable String uuid,@RequestBody Category category) throws CategoryException, CurrentUserSessionException{
		return new ResponseEntity<Category>(categoryserviceimpl.addNewCategory(uuid,category),HttpStatus.CREATED);
		
	}
	@PostMapping(value = "/delete/{uuid}/{category_id}")
	public ResponseEntity<String> remove_category_Handaller( @PathVariable String uuid,@PathVariable Integer category_id) throws CategoryException, CurrentUserSessionException{
		return new ResponseEntity<String>(categoryserviceimpl.removeCategory(uuid,category_id),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/viewAll")
	public ResponseEntity<List<Category>> View_All_category_Handaller() throws CategoryException{
		return new ResponseEntity<List<Category>>(categoryserviceimpl.viewAllCategory(),HttpStatus.OK);
		
	}
}
