package com.javabandits.fullstackjava.dbconnections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.javabandits.fullstackjava.model.Product;


public class DatabaseConnections {
	
	//Connect to mysql database product table
	public SessionFactory mySqlProductConnection() {
		//set up the configuartion object based off of hibernate.cfg.xml file
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		
		//make a sessionfactory object to be used when communicating with mysql 
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		return sessionFactory;
	}
	
	
	


}
