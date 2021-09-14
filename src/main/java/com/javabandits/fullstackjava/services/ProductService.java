package com.javabandits.fullstackjava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.repository.ProductRepository;

@Service
public class ProductService {
	
	ProductRepository repo = new ProductRepository();
	
	public boolean addProduce(Product product) {
		return repo.save(product);
	}

	public Product getProduct(int id) {
		return repo.getById(id);
	}

	public List<Product> getAllProducts() {
		return repo.getAllProducts();
	}

	public boolean deleteProduct(int id) {
		return repo.deleteProduct(id);
	}

	public List<Product> getProductPriceRange(int from, int to) {
		return repo.getProductPriceRange(from,to);
	}


	
}
