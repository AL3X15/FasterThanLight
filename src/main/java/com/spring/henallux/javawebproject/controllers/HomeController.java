package com.spring.henallux.javawebproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value = "/")
public class HomeController extends ControllerBase {
	@Autowired
	public HomeController(MessageSource messageSource) {
		super(messageSource);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String hello(final Model model, Locale locale, Authentication authentication) {
		String name;
		if (authentication == null) name = getMessageSource().getMessage("stranger", null, locale);
		else name = authentication.getName();

		model.addAttribute("title", getMessageSource().getMessage("home", null, locale));
		model.addAttribute("name", name);

		return "integrated:home";
	}
}
