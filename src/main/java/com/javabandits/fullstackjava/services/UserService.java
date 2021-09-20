package com.javabandits.fullstackjava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javabandits.fullstackjava.model.User;
import com.javabandits.fullstackjava.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository repo = new UserRepository();

	public boolean addUser(User user) {
		return repo.save(user);
	}

	public User getUser(int id) {
		return repo.getByID(id);
	}

	public User checkUserExist(User user) {
		return repo.checkUserExist(user);
	}

	public List<User> getAllusers() {
		return repo.getAllUsers();
	}

	public boolean updateUser(User user) {
		return repo.updateUser(user);
	}

	public boolean addProductToWishList(String userEmail, int productId) {
		return repo.addProductToWishList(userEmail,productId);
	}

}
