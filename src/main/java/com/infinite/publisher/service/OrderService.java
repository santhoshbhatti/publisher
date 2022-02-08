package com.infinite.publisher.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.infinite.publisher.aggregations.Aggregator;
import com.infinite.publisher.model.LineItem;
import com.infinite.publisher.model.Order;
import com.infinite.publisher.model.Outbox;
import com.infinite.publisher.repository.LineItemsRepository;
import com.infinite.publisher.repository.OrdersRepository;
import com.infinite.publisher.repository.OutboxRepository;
import com.infinite.publisher.vos.LineItemVo;
import com.infinite.publisher.vos.OrderVo;

@Service
public class OrderService {
	@Autowired
	OrdersRepository orderRepository;

	@Autowired
	LineItemsRepository lineItemsRepository;

	@Autowired
	OutboxRepository outboxRepository;

	@Autowired
	private Gson gson;

	@Transactional
	public OrderVo createOrder(Order order) {
		List<LineItem> lineItems = order.getLineitems();
		order.setLineitems(null);
		Order savedOrder = orderRepository.save(order);
		List<LineItem> savedLineItems = new ArrayList<>();
		lineItems.forEach((LineItem li) -> {
			li.setOrder(savedOrder);
			LineItem savedLineItem = lineItemsRepository.save(li);
			savedLineItems.add(savedLineItem);
			lineItemsRepository.flush();
		});
		

		OrderVo ordervo = processOrderAggregator(savedOrder,savedLineItems);

		String orderJson = gson.toJson(ordervo);
		Outbox outbox = new Outbox();
		outbox.setType("order");
		outbox.setEntity(orderJson);
		outboxRepository.save(outbox);

		// build a hirarchy of entites which are being updated
		// savedOrder.getLineitems().forEach(li -> li.setOrder(savedOrder));
		return ordervo;

	}

	private OrderVo processOrderAggregator(Order savedOrder,List<LineItem> lineItems) {
		OrderVo ordervo = new OrderVo();
		ordervo.setOrderId(savedOrder.getOrderId());
		ordervo.setPurchaserId(savedOrder.getPurchaserId());
		ordervo.setTotalPrize(savedOrder.getTotalPrize());
		ordervo.setDate(savedOrder.getDate());
		
		List<LineItemVo> lineItemvos = new ArrayList<>();
		lineItems.forEach((LineItem li) -> {
			LineItemVo livo = getLineItemVo(li);
			lineItemvos.add(livo);
		});
		ordervo.setLineitems(lineItemvos);
		return ordervo;
	}

	private LineItemVo getLineItemVo(LineItem li) {
		LineItemVo livo = new LineItemVo();
		livo.setId(li.getId());
		livo.setItemName(li.getItemName());
		livo.setOrderId(li.getOrder().getOrderId());
		livo.setPurchaserId(li.getPurchaserId());
		livo.setTotalPrize(li.getTotalPrize());
		return livo;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

}
