package com.javabandits.fullstackjava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javabandits.fullstackjava.dbconnections.DatabaseConnections;

@SpringBootApplication
public class FullstackjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackjavaApplication.class, args);
		
		DatabaseConnections myDatabase = new DatabaseConnections();
		SessionFactory mySqlSessionFactory = myDatabase.mySqlConnection();
		
		Session session = mySqlSessionFactory.openSession();
		
		// do some jdbc stuff - CRUD : Create Remove Update Delete
		
		session.close();
	}

}
