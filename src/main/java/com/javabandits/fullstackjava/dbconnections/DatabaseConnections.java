package com.javabandits.fullstackjava.dbconnections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnections {
	
	public SessionFactory mySqlConnection() {
		Configuration con = new Configuration().configure();
		SessionFactory sessionFactory = con.buildSessionFactory();
		return sessionFactory;
	}
	


}
