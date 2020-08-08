package com.spring.henallux.javawebproject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BasketEntry {
	private int shipId;
	@NotNull
	@Min(0)
	private Integer quantity;

	//Setters section
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	//Getters section
	public int getShipId() {
		return shipId;
	}

	public Integer getQuantity() {
		return quantity;
	}
}
