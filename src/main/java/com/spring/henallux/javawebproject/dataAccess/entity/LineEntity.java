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
	private Integer quantity;
	@Column(name = "price")
	private Double price;

	@JoinColumn(name = "order_id", referencedColumnName = "id")
	@ManyToOne
	private OrderEntity order;
	@JoinColumn(name = "ship_id", referencedColumnName = "id")
	@ManyToOne
	private ShipEntity ship;

	public LineEntity() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public void setShip(ShipEntity ship) {
		this.ship = ship;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public ShipEntity getShip() {
		return ship;
	}
}
