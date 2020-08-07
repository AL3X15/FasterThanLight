package com.spring.henallux.javawebproject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ship")
public class ShipEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "name")
	private String name;
	@Column(name = "URL_image")
	private String URLImage;
	@Column(name = "ship_code")
	private String shipCode;
	@Column(name = "width_ship")
	private Integer width;
	@Column(name = "length_ship")
	private Integer length;
	@Column(name = "height_ship")
	private Integer height;
	private String builder;

	@JoinColumn(name = "category_id", referencedColumnName = "id")
	@ManyToOne
	private CategoryEntity category;
	@OneToMany(mappedBy = "ship")
	private Collection<ShipLanguageEntity> translations;
	@OneToMany(mappedBy = "ship")
	private Collection<LineEntity> lines;

	public ShipEntity() {
	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setURLImage(String URLImage) {
		this.URLImage = URLImage;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public void setTranslations(Collection<ShipLanguageEntity> translations) {
		this.translations = translations;
	}

	public void setLines(Collection<LineEntity> lines) {
		this.lines = lines;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public String getName() {
		return name;
	}

	public String getURLImage() {
		return URLImage;
	}

	public String getShipCode() {
		return shipCode;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getLength() {
		return length;
	}

	public Integer getHeight() {
		return height;
	}

	public String getBuilder() {
		return builder;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public Collection<ShipLanguageEntity> getTranslations() {
		return translations;
	}

	public Collection<LineEntity> getLines() {
		return lines;
	}

}
