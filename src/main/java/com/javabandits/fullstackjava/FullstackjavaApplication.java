package com.javabandits.fullstackjava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javabandits.fullstackjava.dbconnections.DatabaseConnections;
import com.javabandits.fullstackjava.model.Product;
import com.javabandits.fullstackjava.repository.ProductRepository;

@SpringBootApplication
public class FullstackjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackjavaApplication.class, args);
		
		
	}

}
