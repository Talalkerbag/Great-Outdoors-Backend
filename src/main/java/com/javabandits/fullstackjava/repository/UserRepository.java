package com.javabandits.fullstackjava.repository;

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
		session.save(user);
		tx.commit();
		session.clear();
        session.close();
		System.out.println("User saved");
		return true;
	}

	public User getByID(int id) {
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,id);
		session.clear();
        session.close();
		System.out.println("one product fetched");
		return user;
	}
	
	

}
