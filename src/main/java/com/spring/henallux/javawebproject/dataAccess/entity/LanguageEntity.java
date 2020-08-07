package com.spring.henallux.javawebproject.dataAccess.entity;

import com.spring.henallux.javawebproject.model.Category;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "language")
public class LanguageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "language")
	private Collection<ShipLanguageEntity> descriptionsShip;
	@OneToMany(mappedBy = "language")
	private Collection<CategoryLanguageEntity> descriptionsCategory;


	public LanguageEntity() {

	}

	//Setters section
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescriptionsShip(Collection<ShipLanguageEntity> descriptionsShip) {
		this.descriptionsShip = descriptionsShip;
	}

	public void setDescriptionsCategory(Collection<CategoryLanguageEntity> descriptionsCategory) {
		this.descriptionsCategory = descriptionsCategory;
	}


	//Getters section
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<ShipLanguageEntity> getDescriptionsShip() {
		return descriptionsShip;
	}

	public Collection<CategoryLanguageEntity> getDescriptionsCategory() {
		return descriptionsCategory;
	}

}
