package com.javabandits.fullstackjava.resources;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public boolean addProduct(@RequestBody Product prod)  {
		System.out.println("Request to add product reached!");
		return productService.addProduct(prod);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Product/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		System.out.println("Request to fetch product reached");
		return productService.getProduct(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Product/getByPriceRange/{from}/{to}")
	public List<Product> getProductPriceRange(@PathVariable("from") int from,@PathVariable("to") int to) {
		System.out.println("Request to fetch product reached");
		return productService.getProductPriceRange(from,to);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Product/all")
	public List<Product> getAllProducts() {
		System.out.println("Request to fetch all products reached");
		return productService.getAllProducts();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/Product/delete/{id}")
	public boolean deleteProduct(@PathVariable("id") int id) {
		System.out.println("Request to delete product reached");
		return productService.deleteProduct(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/Product/update")
	public boolean updateProduct(@RequestBody Product product) {
		System.out.println("Request to update product reached");
		return productService.updateProduct(product);
	}

	
	
}
