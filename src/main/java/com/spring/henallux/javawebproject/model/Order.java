package com.spring.henallux.javawebproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

public class Order {
	private Integer id;
	@Future
	private Date deliveryDate;
	private Date creationDate;
	private Boolean isPay;

	private User customer;
	private Collection<Line> lines;

	public Order() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public void setLine(Collection<Line> lines) {
		this.lines = lines;
	}

	public void setIsPay(Boolean isPay) {
		this.isPay = isPay;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public User getCustomer() {
		return customer;
	}

	public Collection<Line> getLines() {
		return lines;
	}

	public Boolean getIsPay() {
		return isPay;
	}
}
