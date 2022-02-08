package com.infinite.publisher.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.publisher.model.Order;
import com.infinite.publisher.repository.OrdersRepository;
import com.infinite.publisher.service.OrderService;
import com.infinite.publisher.vos.OrderVo;

@RestController
@RequestMapping(value = "/rest/orders")
public class OrdersResource {
	@Autowired
	OrderService orderService;
	@GetMapping(value = "/")
	public java.util.List<Order> getAll() {
		return orderService.getAllOrders();
	}

	@PostMapping(value = "/load")
	public OrderVo persist(@RequestBody final Order order) {
		OrderVo ordervo = orderService.createOrder(order);
		return ordervo;

	}

}
