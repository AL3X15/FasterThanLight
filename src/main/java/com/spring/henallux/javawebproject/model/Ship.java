package com.spring.henallux.javawebproject.model;

public class Ship {
	private Integer id;
	private String name;
	private Integer length;
	private Integer width;
	private Integer height;
	private String builder;
	private Double unitPrice;
	private String URLImage;
	private Category category;


	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setURLImage(String URLImage) {
		this.URLImage = URLImage;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//Getters section
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getLength() {
		return length;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public String getBuilder() {
		return builder;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public String getURLImage() {
		return URLImage;
	}

	public Category getCategory() {
		return category;
	}
}
