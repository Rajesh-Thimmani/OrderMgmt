package com.example.orderservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.orderservice.model.Order;

/**
 * 
 * @author Rajesh
 *
 */

@FeignClient(name="order-item-service", url = "localhost:8088")
public interface OrderItemServiceProxy {
	@PostMapping("/order-items/create/order")
	public Order createOrder(@RequestBody Order order);
	
	@GetMapping("/order-items/order/{id}")
	public Order getOrderById(@PathVariable("id") Long id);
}
