package com.wolken.wolkenapp.dto;

import java.io.*;

public class BiscuitsDTO implements Serializable {
	
	//serializable class requires this variable
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String brand;
	private int qty;
	private double price;

	public BiscuitsDTO() {

	}

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
