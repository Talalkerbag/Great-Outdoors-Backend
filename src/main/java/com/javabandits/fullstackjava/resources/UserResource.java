package com.javabandits.fullstackjava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.model.User;
import com.javabandits.fullstackjava.services.UserService;

@RestController
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/User/addUser")
	public boolean addProduct(@RequestBody User user) {
		System.out.println("Request to add user reached!");
		return userService.addUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/User/{id}")
	public User getUser(@PathVariable("id") int id) {
		System.out.println("Request to fetch user reached");
		return userService.getUser(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/User/all")
	public List<User> getAllUsers() {
		System.out.println("Request to fetch all users reached");
		return userService.getAllusers();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/User/checkUser")
	public User checkUserExist(@RequestBody User user) {
		System.out.println("Request to check user exist reached");
		return userService.checkUserExist(user);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/User/update")
	public boolean updateUser(@RequestBody User user) {
		System.out.println("Request to update user reached");
		return userService.updateUser(user);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("UserProduct/add/wishlist/{product_id}")
	public boolean addProductToWishList(@RequestBody String userEmail, @PathVariable("product_id") int productId) {
		System.out.println("Request to add product to wishlist reached!");
		return userService.addProductToWishList(userEmail,productId);
	}
}
