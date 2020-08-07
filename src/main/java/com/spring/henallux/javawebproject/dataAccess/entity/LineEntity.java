package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "line")
public class LineEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "quantity")
	private Double quantity;
	@Column(name = "price_per_kilo")
	private Double pricePerKilo;

	@JoinColumn(name = "order_id", referencedColumnName = "id")
	@ManyToOne
	private OrderEntity order;
	@JoinColumn(name = "cheese_id", referencedColumnName = "id")
	@ManyToOne
	private CheeseEntity cheese;

	public LineEntity() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setPricePerKilo(Double pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public void setCheese(CheeseEntity cheese) {
		this.cheese = cheese;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Double getPricePerKilo() {
		return pricePerKilo;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public CheeseEntity getCheese() {
		return cheese;
	}
}
