package com.spring.henallux.javawebproject.controllers;

import com.spring.henallux.javawebproject.dataAccess.entity.UserEntity;
import com.spring.henallux.javawebproject.exceptions.ShipLanguageNotFound;
import com.spring.henallux.javawebproject.model.Line;
import com.spring.henallux.javawebproject.model.Order;
import com.spring.henallux.javawebproject.model.Ship;
import com.spring.henallux.javawebproject.model.User;
import com.spring.henallux.javawebproject.services.LineServices;
import com.spring.henallux.javawebproject.services.OrderServices;
import com.spring.henallux.javawebproject.services.ShipLanguageServices;
import com.spring.henallux.javawebproject.services.UserServices;
import com.spring.henallux.javawebproject.utility.Constants;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
@SessionAttributes(Constants.BASKET)
public class OrderController extends ControllerBase {
	private final OrderServices orderServices;
	private final LineServices lineServices;
	private final UserServices userServices;
	private final ShipLanguageServices shipLanguageServices;


	@Autowired
	public OrderController(OrderServices orderServices,
	                       MessageSource messageSource,
	                       LineServices lineServices,
	                       UserServices userServices,
	                       ShipLanguageServices shipLanguageServices) {
		super(messageSource);
		this.orderServices = orderServices;
		this.lineServices = lineServices;
		this.userServices = userServices;
		this.shipLanguageServices = shipLanguageServices;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getOrders(Model model, Locale locale, Authentication authentication) {
		Collection<Order> orders = orderServices.findOrders(
				((UserEntity) authentication.getPrincipal()).getUsername()
		);
		orders.stream().collect(Collectors.toList()).sort(Comparator.comparing(Order::getCreationDate).reversed());
		model.addAttribute("formatDate", new SimpleDateFormat("dd-MM-yy"));
		model.addAttribute("orders", orders);
		model.addAttribute("title", getMessageSource().getMessage("orderTitle", null, locale));

		return "integrated:orders";
	}

	@RequestMapping(value = "/makeOrder", method = RequestMethod.GET)
	public String makeCommand(@ModelAttribute(value = Constants.BASKET) HashMap<Ship, Integer> basket,
	                          Authentication authentication) {
		try {
			Order order = new Order();

			order.setIsPay(false);

			UserEntity userEntity = (UserEntity) authentication.getPrincipal();
			User user = userServices.findUser(userEntity.getUsername());

			order.setCustomer(user);
			Order orderSave = orderServices.saveOrder(order);

			for (Map.Entry<Ship, Integer> basketEntry : basket.entrySet()) {
				lineServices.saveLine(new Line() {{
					setQuantity(basketEntry.getValue());
					setShip(basketEntry.getKey());
					setPrice(basketEntry.getKey().getUnitPrice());
					setOrder(orderSave);
				}});
			}

			basket.clear();

			return "redirect:../order";
		} catch (Exception e) {
			return "redirect:../";
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getOrderLine(@PathVariable(value = "id") String orderId, Model model, Locale locale) {
		try {
			int id = Integer.valueOf(orderId);
			Collection<Line> lines = lineServices.findLines(id);
			for (Line line : lines) {
				try {
					line.getShip().setName(shipLanguageServices.findShip(line.getShip().getId(), locale).getDescription());
				} catch (Exception e) {
					return "redirect:../";
				}
			}
			model.addAttribute("lines", lines);
			model.addAttribute("order", lines.stream().collect(Collectors.toList()).get(0).getOrder());
			model.addAttribute("title", getMessageSource().getMessage("orderTitle", null, locale));
			model.addAttribute("language", getMessageSource().getMessage("languageCode", null, locale));

			return "integrated:order";
		} catch (Exception e) {
			return "redirect:../";
		}
	}
}
