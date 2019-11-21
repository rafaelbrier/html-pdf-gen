package com.report.html.models;

public class Book {

	private String name;
	private Double price;
	private Boolean available;

	public Book() {
		super();
	}

	public Book(String name, Double price, Boolean available) {
		super();
		this.name = name;
		this.price = price;
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
