package com.javabandits.fullstackjava.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private int id;
	private String name;
	private String description;
	private String imageuri;
	private double price;
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getImageuri() {
		return imageuri;
	}
	public void setImageuri(String imageuri) {
		this.imageuri = imageuri;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuanity() {
		return quantity;
	}
	public void setQuanity(int quanity) {
		this.quantity = quanity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
