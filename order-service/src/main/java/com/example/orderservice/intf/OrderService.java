package com.example.orderservice.intf;

import java.util.List;

import com.example.orderservice.dto.OrderDTO;

public interface OrderService {

	public OrderDTO createOrder(OrderDTO orderDTO);
	
	public OrderDTO getOrderById(Long id);
	
	public List<OrderDTO> getAllOrders();
	
}
