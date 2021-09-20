package com.javabandits.fullstackjava.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.javabandits.fullstackjava.dbconnections.DatabaseConnections;
import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.model.User;

public class UserProductRepository {
	DatabaseConnections myDatabase = new DatabaseConnections();
	SessionFactory mySqlSessionFactory = myDatabase.mySqlConnection();
	
	

	public boolean save(String userEmail, int productId) {
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
			getUser.getProducts().add(getProduct);
			getUser.getWishList().remove(getProduct);
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
	
	public boolean remove(String userEmail, int productId) {
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
			session.update(getUser);
			tx.commit();
			session.clear();
	        session.close();
			System.out.println("user product removed");
			return true;
		}else {
			System.out.println("User OR Product do not exist");
			
			return false;
		}
	}

	public Set<Product> getAllUserProducts(String userEmail) {
		Session session = mySqlSessionFactory.openSession();
		session.beginTransaction();
		User getUser = new User();
		try {
			getUser = session.createQuery("from User U where U.email = '" + userEmail + "'",User.class).getSingleResult();
			System.out.println(getUser.toString());
		}catch(NoResultException e) {
			
		}
		session.getTransaction().commit();
		session.clear();
        session.close();
		return getUser.getProducts();
	}

	public boolean removeUserProductFromWishlist(String userEmail, int productId) {
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
			getUser.getWishList().remove(getProduct);
			session.update(getUser);
			tx.commit();
			session.clear();
	        session.close();
			System.out.println("user product removed from wishlist");
			return true;
		}else {
			System.out.println("User OR Product do not exist");
			
			return false;
		}
	}

	public boolean removeAllProductsFromUserCart(String userEmail) {
		Session session = mySqlSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User getUser = new User();
		
		try {
			getUser = session.createQuery("from User U where U.email = '" + userEmail + "'",User.class).getSingleResult();
			System.out.println(getUser.toString());
		}catch(NoResultException e) {
			
		}
		
		if(getUser.getEmail() != null) {
			getUser.getProducts().removeAll(getUser.getProducts());
			session.update(getUser);
			tx.commit();
			session.clear();
	        session.close();
			System.out.println("all user products removed from cart");
			return true;
		}else {
			System.out.println("User OR Product do not exist");
			
			return false;
		}
	}
}
