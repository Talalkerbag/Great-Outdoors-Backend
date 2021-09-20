package com.javabandits.fullstackjava.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.model.User;
import com.javabandits.fullstackjava.repository.UserProductRepository;

@Service
public class UserProductService {
	
	UserProductRepository repo = new UserProductRepository();

	public boolean addUserProduct(String userEmail, int productId) {
		return repo.save(userEmail, productId);
	}
	
	public boolean removeUserProduct(String userEmail, int productId) {
		return repo.remove(userEmail, productId);
	}


	public Set<Product> getAllUserProducts(String userEmail) {
		return repo.getAllUserProducts(userEmail);
	}

	public boolean removeUserProductFromWishlist(String userEmail, int productId) {
		return repo.removeUserProductFromWishlist(userEmail, productId);
	}

	public boolean removeAllProductsFromUserCart(String userEmail) {
		return repo.removeAllProductsFromUserCart(userEmail);
	}
	
	
	

}
