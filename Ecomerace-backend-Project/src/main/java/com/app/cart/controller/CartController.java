package com.app.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cart.service.CartServiceImpl;
import com.app.exception.CartException;
import com.app.exception.CurrentUserSessionException;
import com.app.exception.ProductException;
import com.app.model.Cart;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartserviceimpl;
	
	@PostMapping(value = "/addTOcart/{uuid}/{prod_id}/{quaintity}")
	public ResponseEntity<Cart> add_new_cart(@PathVariable String uuid,@PathVariable Integer prod_id,@PathVariable Integer quaintity) throws CartException, ProductException, CurrentUserSessionException{
		
		return new ResponseEntity<Cart>(cartserviceimpl.addtoCart(uuid, prod_id,quaintity),HttpStatus.OK);
	}
	
	@GetMapping(value = "/List/{uuid}")
	public ResponseEntity<List<Cart>> All_cart_list_Handaller(@PathVariable String uuid) throws CartException, ProductException, CurrentUserSessionException{
		
		return new ResponseEntity<List<Cart>>(cartserviceimpl.findListOfCart(uuid),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{uuid}/{cart_id}")
	public ResponseEntity<Cart> delete_cart_list_Handaller(@PathVariable String uuid ,@PathVariable Integer cart_id) throws CartException, ProductException, CurrentUserSessionException{
		
		return new ResponseEntity<Cart>(cartserviceimpl.removeCartList(uuid,cart_id),HttpStatus.OK);
	}
}
