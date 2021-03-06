package com.javabandits.fullstackjava.repository;




import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.javabandits.fullstackjava.dbconnections.DatabaseConnections;
import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.model.User;


public class ProductRepository  {
	// instantiate myDatabase class
	DatabaseConnections myDatabase = new DatabaseConnections();
	// Set up sessionFactory object from myDatabase class
	SessionFactory mySqlSessionFactory = myDatabase.mySqlConnection();
	
	

	public boolean save(Product product){
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product checkProduct = new Product();
		
		try {
			checkProduct = session.createQuery("from Product P where P.name = '" + product.getName() + "'",Product.class).getSingleResult();
		}catch(NoResultException e) {
			
		}
		
		if(checkProduct.getName() != null) {
			System.out.println("Product already exist");
			return false;
		}else {
			session.save(product);
			tx.commit();
			session.clear();
	        session.close();
			System.out.println("Product saved");
			return true;
		}
	}

	public Product getById(int id) {
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = session.get(Product.class,id);
		session.clear();
        session.close();
		System.out.println("one product fetched");
		return product;
		
	}

	
	public List<Product> getAllProducts() {
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
		List<Product> products = session.createQuery("from Product",Product.class).getResultList();
		session.getTransaction().commit();
		session.clear();
        session.close();
		return products;
		
	}

	public boolean deleteProduct(int id) {
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
		session.createQuery("delete from Product where id = :id").setParameter("id", id).executeUpdate();
		
		session.getTransaction().commit();
		session.clear();
        session.close();
		return true;
	}

	public List<Product> getProductPriceRange(int from, int to) {
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
		List<Product> products = session.createQuery("from Product P where P.price >= " + from + " and P.price <= " + to,Product.class).getResultList();
		session.getTransaction().commit();
		session.clear();
        session.close();
		return products;
	}

	public boolean updateProduct(Product product) {
		System.out.println(product.toString());
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
//		String updateQuery = "update from Product P set P.name = '" + product.getName() + 
//							 "' P.price = " + product.getPrice() +
//							 " P.description = '"+ product.getDescription() +
//							 "' P.quantity = " + product.getQuantity() + 
//							 " P.imageUrl = '" + product.getImageurl() + 
//							 "' P.category = '" + product.getCategory() + 
//							 "' where P.id = " + product.getId();
//		session.createQuery(updateQuery).executeUpdate();
		session.update(product);
        session.getTransaction().commit();
        session.clear();
        session.close();
        return true;
	}
	

}
