package com.spring.henallux.javawebproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@RequestMapping(value = "/presentation")
@Controller
public class PresentationController extends ControllerBase {
	@Autowired
	public PresentationController(MessageSource messageSource) {
		super(messageSource);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getPresentation(Model model, Locale locale) {
		model.addAttribute("title", getMessageSource().getMessage("presentation", null, locale));
		return "integrated:presentation";
	}
}
