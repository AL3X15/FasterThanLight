package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.OrderEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.OrderRepository;
import com.spring.henallux.javawebproject.exceptions.CommandNotFound;
import com.spring.henallux.javawebproject.model.Order;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import com.spring.henallux.javawebproject.utility.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDAO {
	private final OrderRepository dataAccess;
	private final ProviderConverter mapper;
	private final TestModel<Order> testCommand;

	@Autowired
	public OrderDAO(OrderRepository dataAccess, ProviderConverter mapper, TestModel<Order> testCommand) {
		this.dataAccess = dataAccess;
		this.mapper = mapper;
		this.testCommand = testCommand;
	}

	public Order findOrder(int id) throws CommandNotFound {
		Optional<OrderEntity> command = dataAccess.findById(id);

		if (!command.isPresent()) throw new CommandNotFound();
		return mapper.orderEntityToOrderModel(command.get());
	}

	public Collection<Order> findOrders(String username) {
		return dataAccess.findByCustomerUsername(username).stream().map(mapper::orderEntityToOrderModel).collect(Collectors.toList());
	}

	public Order saveOrder(Order order) throws Exception {
		testCommand.setObjectToTest(order);
		if (testCommand.hasError()) throw new Exception(); //TODO better exception
		OrderEntity orderEntity = dataAccess.save(mapper.orderModelToOrderEntity(order));
		return mapper.orderEntityToOrderModel(orderEntity);
	}

	public Order deleteOrder(Order order) {
		dataAccess.delete(mapper.orderModelToOrderEntity(order));
		return order;
	}
}
