package com.spring.henallux.javawebproject.services;


import com.spring.henallux.javawebproject.dataAccess.dao.CheeseDAO;
import com.spring.henallux.javawebproject.model.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CheeseServices {
	private final CheeseDAO dao;

	@Autowired
	public CheeseServices(CheeseDAO dao) {
		this.dao = dao;
	}

	public Collection<Cheese> findAll() {
		return dao.findAllCheese();
	}

	public Cheese find(int id) throws Exception {
		return dao.findCheese(id);
	}
}
