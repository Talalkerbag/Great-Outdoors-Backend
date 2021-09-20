package com.javabandits.fullstackjava.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.javabandits.fullstackjava.dbconnections.DatabaseConnections;
import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.model.User;

public class UserRepository {
	DatabaseConnections myDatabase = new DatabaseConnections();
	SessionFactory mySqlSessionFactory = myDatabase.mySqlConnection();
		
	public boolean save(User user) {
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(!(user.getRole().equals("admin")) || !(user.getRole().equals("product master"))) {
			user.setRole("customer");
		}
		User checkUser = new User();
		
		try {
			checkUser = session.createQuery("from User U where U.email = '" + user.getEmail() + "'",User.class).getSingleResult();
		}catch(NoResultException e) {
			
		}
		
		if(checkUser.getEmail() != null) {
			System.out.println("User already exist");
			return false;
		}else {
			session.save(user);
			tx.commit();
			session.clear();
	        session.close();
			System.out.println("user saved");
			return true;
		}
	}

	public User getByID(int id) {
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,id);
		session.clear();
        session.close();
		System.out.println("one user fetched");
		return user;
	}
	
	public List<User> getAllUsers() {
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
		List<User> users = session.createQuery("from User",User.class).getResultList();
		session.getTransaction().commit();
		session.clear();
        session.close();
		return users;
		
	}

	public User checkUserExist(User user) {
		User getUser = new User();
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
		try {
			getUser = session.createQuery("from User U where U.email = '" + user.getEmail() + "' and U.password = '" + user.getPassword() + "'",User.class).getSingleResult();
		}catch(Exception e) {
			
		}
		session.getTransaction().commit();
		session.clear();
        session.close();
        
	    if(getUser.getUserName() != null) {
	    	System.out.println("User exist: " + getUser.getUserName());
	    	return getUser;
	    }else {
	    	System.out.println("User does not exist");
	    	return new User();
	    }
	}

	public boolean addProductToWishList(String userEmail, int productId) {
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User getUser = new User();
		Product getProduct = new Product();
		
		try {
			getUser = session.createQuery("from User U where U.email = '" + userEmail + "'",User.class).getSingleResult();
			System.out.println(getUser.toString());
			getProduct = session.createQuery("from Product P where P.product_id = " + productId,Product.class).getSingleResult();
			System.out.println(getProduct.toString());
		}catch(NoResultException e) {
			
		}
		
		if(getUser.getEmail() != null && getProduct.getName() != null) {
			getUser.getProducts().remove(getProduct);
			getUser.getWishList().add(getProduct);
			session.update(getUser);
			tx.commit();
			session.clear();
	        session.close();
			System.out.println("user product saved");
			return true;
		}else {
			System.out.println("User OR Product do not exist");
			
			return false;
		}
	}
	
}
