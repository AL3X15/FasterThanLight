package com.spring.henallux.javawebproject.controllers;

import com.spring.henallux.javawebproject.model.*;
import com.spring.henallux.javawebproject.services.CategoryLanguageServices;
import com.spring.henallux.javawebproject.services.CategoryServices;
import com.spring.henallux.javawebproject.services.ShipLanguageServices;
import com.spring.henallux.javawebproject.services.ShipServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//TODO afficher données vaisseau

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController extends ControllerBase {
	private final CategoryServices categoryServices;
	private final CategoryLanguageServices categoryLanguageServices;
	private final ShipServices shipServices;
	private final ShipLanguageServices shipLanguageServices;

	@Autowired
	public CatalogController(MessageSource messageSource,
	                         CategoryServices categoryServices,
	                         CategoryLanguageServices categoryLanguageServices,
	                         ShipServices shipServices,
	                         ShipLanguageServices shipLanguageServices) {
		super(messageSource);
		this.categoryServices = categoryServices;
		this.categoryLanguageServices = categoryLanguageServices;
		this.shipServices = shipServices;
		this.shipLanguageServices = shipLanguageServices;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String catalog(Model model, Locale locale) {
		List<Category> categories = (List<Category>) categoryServices.findAll();
		for (Category category : categories) {
			category.setShips(shipServices.findByCategory(category.getId()));
			try {
				category.setName(categoryLanguageServices.findCategory(category.getId(), locale).getDescription());
				for (Ship ship : category.getShips()) {
					ship.setName(shipLanguageServices.findShip(ship.getId(), locale).getDescription());
				}
			} catch (Exception e) {
				return "redirect:../";
			}
		}

		model.addAttribute("categories", categories);
		model.addAttribute("title", getMessageSource().getMessage("catalog", null, locale));
		return "integrated:catalog";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String ship(@PathVariable(value = "id") String id, Model model, Locale locale) {
		try {
			int idConverted = Integer.valueOf(id);
			ShipLanguage shipLanguage = shipLanguageServices.findShip(idConverted, locale);

			BasketEntry basketEntry = new BasketEntry() {{
				setShipId(shipLanguage.getShip().getId());
				setQuantity(1);
			}};

			if (!model.containsAttribute("basketEntry"))
				model.addAttribute("basketEntry", basketEntry);

			model.addAttribute("shipLanguage", shipLanguage);
			model.addAttribute("title", getMessageSource().getMessage("ship", null, locale));

			return "integrated:ship";
		} catch (Exception e) {
			return "redirect:../";
		}

	}
}
