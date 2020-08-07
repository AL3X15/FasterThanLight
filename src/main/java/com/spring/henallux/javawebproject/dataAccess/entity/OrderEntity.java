package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "order_entity")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "delivery_date")
	private Date deliveryDate;
	@Column(name = "creation_date")
	private Date creationDate;
	@Column(name = "is_pay")
	private Boolean isPay;

	@JoinColumn(name = "username", referencedColumnName = "username")
	@ManyToOne
	private UserEntity customer;
	@OneToMany(mappedBy = "order")
	private Collection<LineEntity> lines;

	public OrderEntity() {

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

	public void setUserName(UserEntity customer) {
		this.customer = customer;
	}

	public void setLines(Collection<LineEntity> lines) {
		this.lines = lines;
	}

	public void setIsPay(Boolean isPay) {
		this.isPay = isPay;
	}

	public void setCustomer(UserEntity customer) {
		this.customer = customer;
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

	public UserEntity getCustomer() {
		return customer;
	}

	public Collection<LineEntity> getLines() {
		return lines;
	}

	public Boolean getIsPay() {
		return isPay;
	}
}
