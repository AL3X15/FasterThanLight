package com.spring.henallux.javawebproject.controllers;

import com.spring.henallux.javawebproject.model.Order;
import com.spring.henallux.javawebproject.services.OrderServices;
import com.spring.henallux.javawebproject.utility.AddDays;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/paid")
public class PaidController extends ControllerBase {
	private final OrderServices orderServices;

	public PaidController(MessageSource messageSource, OrderServices orderServices) {
		super(messageSource);
		this.orderServices = orderServices;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String paid(@PathVariable("id") String id, Model model, Locale locale) {
		try {
			int convertedId = Integer.valueOf(id);
			Order order = orderServices.findOrder(convertedId);
			order.setIsPay(true);
			order.setDeliveryDate(AddDays.addDays(new Date(), 3));
			orderServices.saveOrder(order);
			model.addAttribute("title", getMessageSource().getMessage("paid", null, locale));

			return "integrated:paid";
		} catch (Exception e) {
			return "redirect:../";
		}
	}
}
