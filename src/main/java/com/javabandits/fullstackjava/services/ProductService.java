package com.javabandits.fullstackjava.services;

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

	
}
