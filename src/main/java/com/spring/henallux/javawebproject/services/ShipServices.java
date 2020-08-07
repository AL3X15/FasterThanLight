package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.ShipDAO;
import com.spring.henallux.javawebproject.exceptions.CategoryNotFound;
import com.spring.henallux.javawebproject.exceptions.ShipNotFound;
import com.spring.henallux.javawebproject.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShipServices {
	private final ShipDAO dao;

	@Autowired
	public ShipServices(ShipDAO dao) {
		this.dao = dao;
	}

	public Collection<Ship> findAll() {
		return dao.findAllShip();
	}

	public Ship find(int id) throws ShipNotFound {
		return dao.findShip(id);
	}
}