package com.javabandits.fullstackjava.services;

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

}
