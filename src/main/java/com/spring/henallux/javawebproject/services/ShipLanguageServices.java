package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.ShipLanguageDAO;
import com.spring.henallux.javawebproject.exceptions.ShipLanguageNotFound;
import com.spring.henallux.javawebproject.model.ShipLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ShipLanguageServices {
	private final ShipLanguageDAO dao;

	@Autowired
	public ShipLanguageServices(ShipLanguageDAO dao) {
		this.dao = dao;
	}

	public ShipLanguage findShip(int shipId, Locale locale) throws ShipLanguageNotFound {
		return dao.findShip(shipId, locale);
	}
}
