package com.spring.henallux.javawebproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/authenticated")
public class AuthenticatedController extends ControllerBase {
	@Autowired
	public AuthenticatedController(MessageSource messageSource) {
		super(messageSource);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String authenticatedPage(final Model model, Locale locale) {
		model.addAttribute("title", getMessageSource().getMessage("authenticatedPageTitle", null, locale));

		return "integrated:authenticated";
	}
}
