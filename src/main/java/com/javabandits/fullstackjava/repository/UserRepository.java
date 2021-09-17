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
		user.setRole("customer");

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
	
}
