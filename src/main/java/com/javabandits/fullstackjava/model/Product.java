package com.javabandits.fullstackjava.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int product_id;
	private String name;
	private String description;
	private String imageurl;
	private double price;
	private int quantity;
	private String category;
	
//	@ManyToMany(mappedBy = "products", fetch=FetchType.EAGER)
//	private List<User> users = new ArrayList<User>();
//	
//	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageuri) {
		this.imageurl = imageuri;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", description=" + description + ", imageurl="
				+ imageurl + ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Product() {
		super();
		
	}
	
	
}
