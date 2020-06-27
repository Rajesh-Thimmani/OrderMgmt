package com.example.orderservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.orderservice.dto.OrderItemDTO;

/**
 * 
 * @author Rajesh
 *
 */

@Configuration
@FeignClient(name="order-item-service", url = "localhost:8088")
public interface OrderItemServiceProxy {

	@GetMapping("/order-items/orderId/{id}")
	public ResponseEntity<List<OrderItemDTO>> getOrderByOrderId(@PathVariable("id") long id);
	
	@PostMapping("/order-items/create/order/item")
	public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO);
	
	
}
