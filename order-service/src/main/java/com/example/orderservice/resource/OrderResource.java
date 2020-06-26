package com.example.orderservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.model.Order;
import com.example.orderservice.proxy.OrderItemServiceProxy;

import feign.FeignException;

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
	public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
		try {
			//service call
			Order order = orderItemServiceProxy.getOrderById(id);
			return new ResponseEntity<>(order, HttpStatus.OK);
		}catch(FeignException feignException) {
			HttpStatus status = HttpStatus.resolve(feignException.status());
			if(null == status) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			return new ResponseEntity<>(feignException.getMessage(),status);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
