package com.order.item.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.item.service.business.OrderItemBusinessService;
import com.order.item.service.model.Order;
import com.order.item.service.model.OrderItem;

/**
 * 
 * @author Rajesh
 *
 */
@RestController
@RequestMapping("order-items")
public class OrderItemResource {

	@Autowired
	private OrderItemBusinessService orderItemBusinessService;

	
	/**
	 * create the order details
	 * @param order
	 * @return
	 */
	@PostMapping(value = "/create/order")
	public Order createOrder(@RequestBody Order order) {
		try {
			//service call
			return orderItemBusinessService.createOrder(order);
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * get the order details by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/order/{id}")
	public Order getOrderById(@PathVariable("id") Long id) {
		try {
			//service call
			return orderItemBusinessService.getOrderById(id);
		}catch(Exception exception) {
			throw exception;
		}
	}

	
	
	/**
	 * get the order item details by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public OrderItem getOrderItemById(@PathVariable("id") Long id) {
		try {
			//service call
			return orderItemBusinessService.getOrderItemById(id);
			
		}catch(Exception exception) {
			throw exception;
		}

	}

}
