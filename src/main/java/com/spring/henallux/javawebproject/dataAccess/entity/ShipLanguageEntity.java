package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_language")
public class ShipLanguageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "description")
	private String description;

	@JoinColumn(name = "ship_id", referencedColumnName = "id")
	@ManyToOne
	private ShipEntity ship;
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	@ManyToOne
	private LanguageEntity language;

	public ShipLanguageEntity() {
	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setShip(ShipEntity ship) {
		this.ship = ship;
	}

	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public ShipEntity getShip() {
		return ship;
	}

	public LanguageEntity getLanguage() {
		return language;
	}

}
