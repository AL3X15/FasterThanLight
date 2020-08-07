package com.spring.henallux.javawebproject.controllers;

import com.spring.henallux.javawebproject.exceptions.CheeseNotFound;
import com.spring.henallux.javawebproject.model.*;
import com.spring.henallux.javawebproject.services.CheeseServices;
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

@Controller
@RequestMapping(value = "/basket")
@SessionAttributes({Constants.BASKET})
public class BasketController extends ControllerBase {
	private final CheeseServices cheeseServices;

	@Autowired
	public BasketController(MessageSource messageSource, CheeseServices cheeseServices) {
		super(messageSource);
		this.cheeseServices = cheeseServices;
	}

	@ModelAttribute(Constants.BASKET)
	public HashMap<Cheese, Double> basket() {
		return new HashMap<>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getBasket(Model model, Locale locale,
	                        @ModelAttribute(Constants.BASKET) HashMap<Cheese, Double> basket) {
		model.addAttribute(Constants.BASKET, basket);
		model.addAttribute("title", getMessageSource().getMessage("basket", null, locale));
		if (!model.containsAttribute("basketEntryEdit"))
			model.addAttribute("basketEntryEdit", new BasketEntry());

		return "integrated:basket";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToBasket(@ModelAttribute(value = Constants.BASKET) HashMap<Cheese, Double> basket,
	                          @Valid @ModelAttribute(value = "basketEntry") BasketEntry basketEntry,
	                          BindingResult result,
	                          RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.basketEntry", result);
			redirectAttributes.addFlashAttribute("basketEntry", basketEntry);
			return "redirect:/catalog/" + basketEntry.getCheeseId();
		}
		try {
			Cheese cheese = cheeseServices.find(basketEntry.getCheeseId());
			if (basketEntry.getQuantity() != 0) {
				if (basket.containsKey(cheese)) basket.replace(cheese, basket.get(cheese) + basketEntry.getQuantity());
				else basket.put(cheese, basketEntry.getQuantity());
			}
			return "redirect:catalog";
		} catch (Exception e) {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String deleteBasketEntry(@ModelAttribute(Constants.BASKET) HashMap<Cheese, Double> basket,
	                                @PathVariable("id") String id) throws Exception {

		try {
			int idConverted = Integer.valueOf(id);
			Cheese cheese = cheeseServices.find(idConverted);

			basket.remove(cheese);
		} catch (Exception e) {
			return "redirect:../";
		}

		return "redirect:../basket";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String editBasketEntry(@Valid @ModelAttribute("basketEntryEdit") BasketEntry basketEntry,
	                              BindingResult result,
	                              RedirectAttributes redirectAttributes,
	                              @ModelAttribute(Constants.BASKET) HashMap<Cheese, Double> basket,
	                              @PathVariable("id") String id) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.basketEntryEdit", result);
			redirectAttributes.addFlashAttribute("basketEntryEdit", basketEntry);
		} else {
			try {
				Cheese cheese = cheeseServices.find(basketEntry.getCheeseId());
				if (basketEntry.getQuantity() == 0) basket.remove(cheese);
				else basket.replace(cheese, basketEntry.getQuantity());
			} catch (Exception e) {
				return "redirect:../";
			}
		}
		return "redirect:../basket";
	}
}
