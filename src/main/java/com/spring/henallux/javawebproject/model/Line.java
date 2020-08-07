package com.spring.henallux.javawebproject.model;


public class Line {
	private Integer id;
	private Double quantity;
	private Double pricePerKilo;

	private Order order;
	private Cheese cheese;

	public Line() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	public void setPricePerKilo(Double pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Order getOrder() {
		return order;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public Double getPricePerKilo() {
		return pricePerKilo;
	}
}
