package com.example.orderservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.model.Order;
import com.example.orderservice.proxy.OrderItemServiceProxy;

/**
 * 
 * @author Rajesh
 *
 */

@RestController
@RequestMapping("order-service")
public class OrderResource {

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;
	
	
	/**
	 * create the order 
	 * @param order
	 * @return
	 */
	@PostMapping(value="/create/order")
	public Order createOrder(@RequestBody Order order) {
		try {
			//service call
			return orderItemServiceProxy.createOrder(order);
		}catch(Exception exception) {
			throw exception;
		}
	}

	
	/**
	 * retrieve the order based on id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Order getOrderById(@PathVariable("id") Long id) {
		try {
			//service call
			return orderItemServiceProxy.getOrderById(id);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
