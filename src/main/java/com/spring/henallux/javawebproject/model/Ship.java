package com.spring.henallux.javawebproject.model;

public class Ship {
	private Integer id;
	private String modelCode;
	private String name;
	private Double length;
	private Double width;
	private Double height;
	private String builder;
	private Double unitPrice;
	private String URLImage;
	private Category category;


	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public void setHeight(Double height) {
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

	public String getModelCode() {
		return modelCode;
	}

	public String getName() {
		return name;
	}

	public Double getLength() {
		return length;
	}

	public Double getWidth() {
		return width;
	}

	public Double getHeight() {
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
