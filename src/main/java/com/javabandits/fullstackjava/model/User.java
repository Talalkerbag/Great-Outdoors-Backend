package com.javabandits.fullstackjava.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int user_id;
	private String email;
	private String password;
	private String userName;
	
	
//	@ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//        name = "Product_User", 
//        joinColumns = { @JoinColumn(name = "user_id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "product_id") }
//    )
//	private List<Product> products = new ArrayList<Product>();
//	
//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	
	public User() {
		super();
		
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", password=" + password + ", userName=" + userName
				+ "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	
	

}
