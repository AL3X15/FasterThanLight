package com.spring.henallux.javawebproject.controllers;

import com.spring.henallux.javawebproject.exceptions.EmailAlreadyUse;
import com.spring.henallux.javawebproject.exceptions.UserAlreadyExist;
import com.spring.henallux.javawebproject.model.User;
import com.spring.henallux.javawebproject.services.UserServices;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/register")
public class RegisterController extends ControllerBase {
	private final UserServices userServices;

	public RegisterController(MessageSource messageSource, UserServices userServices) {
		super(messageSource);
		this.userServices = userServices;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm(final Model model, Locale locale) {
		model.addAttribute("title", getMessageSource().getMessage("registerFormTitle", null, locale));

		if (!model.containsAttribute("user"))
			model.addAttribute("user", new User());
		model.addAttribute("title", getMessageSource().getMessage("signup", null, locale));

		return "integrated:register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerResponse(RedirectAttributes redirectAttributes,
	                               @Valid @ModelAttribute("user") User user,
	                               BindingResult result) throws Exception {
		redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
		redirectAttributes.addFlashAttribute("user", user);
		if (result.hasErrors()) {
			return "redirect:/register";
		}
		try {
			userServices.saveUser(user);
		} catch (UserAlreadyExist e) {
			result.rejectValue("username", "AlreadyExist.user", "user already exist");
			return "redirect:/register";
		} catch (EmailAlreadyUse e) {
			result.rejectValue("email", "AlreadyExist.user", "user with this email already exist");
			return "redirect:/register";
		}

		return "redirect:login";
	}
}
