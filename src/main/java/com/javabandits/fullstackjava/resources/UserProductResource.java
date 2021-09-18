package com.javabandits.fullstackjava.resources;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.model.User;
import com.javabandits.fullstackjava.services.UserProductService;


@RestController
public class UserProductResource {
	
	@Autowired
	UserProductService userProductService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/UserProduct/add/{productId}")
	public boolean addUserProduct(@RequestBody String userEmail, @PathVariable("productId") int productId) {
		System.out.println("Request to add product: " + productId + " to user: " + userEmail);
		return userProductService.addUserProduct(userEmail, productId);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/UserProduct/remove/{productId}")
	public boolean removeUserProduct(@RequestBody String userEmail, @PathVariable("id") int productId) {
		System.out.println("Request to remove product: " + productId + " from user: " + userEmail);
		return userProductService.removeUserProduct(userEmail, productId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/UserProduct/all/{userEmail}")
	public Set<Product> getAllUserProducts(@PathVariable("userEmail") String userEmail) {
		System.out.println("Request to fetch all user products reached");
		return userProductService.getAllUserProducts(userEmail);
	}

}
