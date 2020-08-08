package com.spring.henallux.javawebproject.model;


public class Line {
	private Integer id;
	private Integer quantity;
	private Double price;

	private Order order;
	private Ship ship;

	public Line() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Order getOrder() {
		return order;
	}

	public Ship getShip() {
		return ship;
	}

	public Double getPrice() {
		return price;
	}
}
