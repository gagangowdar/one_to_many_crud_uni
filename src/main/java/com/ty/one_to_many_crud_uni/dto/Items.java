package com.ty.one_to_many_crud_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Items {
	@Id
	private int id;
	private String name;
	private double price;
	private int quantity;
	@ManyToOne
	@JoinColumn
	private AmazonOrder amazonOrder;

	public AmazonOrder getAmazonOrder() {
		return amazonOrder;
	}

	public void setAmazonOrder(AmazonOrder amazonOrder) {
		this.amazonOrder = amazonOrder;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
