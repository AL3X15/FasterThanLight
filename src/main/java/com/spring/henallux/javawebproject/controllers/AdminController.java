package com.spring.henallux.javawebproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//TODO ajouter un admin

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends ControllerBase {

	@Autowired
	public AdminController(MessageSource messageSource) {
		super(messageSource);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String adminPage(final Model model, Locale locale) {

		model.addAttribute("title", getMessageSource().getMessage("adminPageTitle", null, locale));

		return "integrated:admin";
	}
}
