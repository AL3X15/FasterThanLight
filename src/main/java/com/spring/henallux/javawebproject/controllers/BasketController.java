package com.spring.henallux.javawebproject.controllers;

import com.spring.henallux.javawebproject.model.*;
import com.spring.henallux.javawebproject.services.ShipLanguageServices;
import com.spring.henallux.javawebproject.services.ShipServices;
import com.spring.henallux.javawebproject.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

//TODO langue

@Controller
@RequestMapping(value = "/basket")
@SessionAttributes({Constants.BASKET})
public class BasketController extends ControllerBase {
	private final ShipServices shipServices;
	private final ShipLanguageServices shipLanguageServices;

	@Autowired
	public BasketController(MessageSource messageSource,
	                        ShipServices shipServices,
	                        ShipLanguageServices shipLanguageServices) {
		super(messageSource);
		this.shipServices = shipServices;
		this.shipLanguageServices = shipLanguageServices;
	}

	@ModelAttribute(Constants.BASKET)
	public HashMap<Ship, Integer> basket() {
		return new HashMap<>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getBasket(Model model, Locale locale,
	                        @ModelAttribute(Constants.BASKET) HashMap<Ship, Integer> basket) {
		model.addAttribute(Constants.BASKET, basket);
		model.addAttribute("title", getMessageSource().getMessage("basket", null, locale));

		try {
			for (Map.Entry<Ship, Integer> entry : basket.entrySet())
				entry.getKey().setName(shipLanguageServices.findShip(entry.getKey().getId(), locale).getDescription());
		} catch (Exception e) {
			return "redirect:../";
		}

		if (!model.containsAttribute("basketEntryEdit"))
			model.addAttribute("basketEntryEdit", new BasketEntry());

		return "integrated:basket";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToBasket(@ModelAttribute(value = Constants.BASKET) HashMap<Ship, Integer> basket,
	                          @Valid @ModelAttribute(value = "basketEntry") BasketEntry basketEntry,
	                          BindingResult result,
	                          RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.basketEntry", result);
			redirectAttributes.addFlashAttribute("basketEntry", basketEntry);
			return "redirect:/catalog/" + basketEntry.getShipId();
		}
		try {
			Ship ship = shipServices.find(basketEntry.getShipId());
			if (basketEntry.getQuantity() != 0) {
				if (basket.containsKey(ship)) basket.replace(ship, basket.get(ship) + basketEntry.getQuantity());
				else basket.put(ship, basketEntry.getQuantity());
			}
			return "redirect:catalog";
		} catch (Exception e) {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String deleteBasketEntry(@ModelAttribute(Constants.BASKET) HashMap<Ship, Integer> basket,
	                                @PathVariable("id") String id) throws Exception {

		try {
			int idConverted = Integer.valueOf(id);
			Ship ship = shipServices.find(idConverted);
			Ship basketShip = new Ship();

			for (Map.Entry<Ship, Integer> e : basket.entrySet()) {
				if (e.getKey().getId() == ship.getId())
					basketShip = e.getKey();
			}

			basket.remove(basketShip);
		} catch (Exception e) {
			return "redirect:../";
		}

		return "redirect:../basket";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String editBasketEntry(@Valid @ModelAttribute("basketEntryEdit") BasketEntry basketEntry,
	                              BindingResult result,
	                              RedirectAttributes redirectAttributes,
	                              @ModelAttribute(Constants.BASKET) HashMap<Ship, Integer> basket,
	                              @PathVariable("id") String id) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.basketEntryEdit", result);
			redirectAttributes.addFlashAttribute("basketEntryEdit", basketEntry);
		} else {
			try {
				Ship ship = shipServices.find(basketEntry.getShipId());
				Ship basketShip = new Ship();

				for (Map.Entry<Ship, Integer> e : basket.entrySet()) {
					if (e.getKey().getId() == ship.getId())
						basketShip = e.getKey();
				}

				if (basketEntry.getQuantity() == 0) basket.remove(basketShip);
				else basket.replace(basketShip, basketEntry.getQuantity());
			} catch (Exception e) {
				return "redirect:../";
			}
		}
		return "redirect:../basket";
	}
}
