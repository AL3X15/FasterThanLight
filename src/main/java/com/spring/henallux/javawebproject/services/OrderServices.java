package com.spring.henallux.javawebproject.services;

import com.spring.henallux.javawebproject.dataAccess.dao.OrderDAO;
import com.spring.henallux.javawebproject.exceptions.CommandNotFound;
import com.spring.henallux.javawebproject.exceptions.NotValidOrder;
import com.spring.henallux.javawebproject.model.Order;
import com.spring.henallux.javawebproject.utility.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServices {
	private final OrderDAO dao;
	private final TestModel<Order> orderTestModel;

	@Autowired
	public OrderServices(OrderDAO dao, TestModel<Order> orderTestModel) {
		this.dao = dao;
		this.orderTestModel = orderTestModel;
	}

	public Order findOrder(int id) throws CommandNotFound {
		return dao.findOrder(id);
	}

	public Collection<Order> findOrders(String username) {
		return dao.findOrders(username);
	}

	public Order saveOrder(Order order) throws Exception {
		orderTestModel.setObjectToTest(order);
		if (orderTestModel.hasError()) throw new NotValidOrder();

		return dao.saveOrder(order);
	}

	public Order deleteOrder(Order order) {
		return dao.deleteOrder(order);
	}
}
