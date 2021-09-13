package com.javabandits.fullstackjava.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.javabandits.fullstackjava.dbconnections.DatabaseConnections;
import com.javabandits.fullstackjava.model.Product;

public class ProductRepository {
	// instantiate myDatabase class
	DatabaseConnections myDatabase = new DatabaseConnections();
	// Set up sessionFactory object from myDatabase class
	SessionFactory mySqlSessionFactory = myDatabase.mySqlProductConnection();

	public boolean save(Product product) {
		// Set up our session object based off sessionFactory class
		Session session = mySqlSessionFactory.openSession();
		// Starting the session transaction
		Transaction tx = session.beginTransaction();
		// add product to our session database table
		session.save(product);
		// committing the transaction
		tx.commit();
		// close the session when done
		session.close();
		System.out.println("Product saved");
		return true;
	}

	public Product getById(int id) {
		// Set up our session object based off sessionFactory class
		Session session = mySqlSessionFactory.openSession();
		// Starting the session transaction
		Transaction tx = session.beginTransaction();
		//get product by id
		Product product = session.get(Product.class,id);
		session.close();
		System.out.println("Product Fetched");
		return product;
		
	}

}
