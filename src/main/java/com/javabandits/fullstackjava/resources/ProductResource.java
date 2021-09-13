package com.javabandits.fullstackjava.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.services.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/Product/addProduct")
	public boolean addProduct(@RequestBody Product prod) {
		System.out.println("Request to add product reached!");
		return productService.addProduce(prod);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Product/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		System.out.println("Request to fetch product reached");
		return productService.getProduct(id);
	}

}
