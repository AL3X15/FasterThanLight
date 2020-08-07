package com.spring.henallux.javawebproject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BasketEntry {
	private int cheeseId;
	@NotNull
	@Min(0)
	private Double quantity;

	public int getCheeseId() {
		return cheeseId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setCheeseId(int cheeseId) {
		this.cheeseId = cheeseId;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
