package com.order.item.service.business;

import com.order.item.service.model.Order;
import com.order.item.service.model.OrderItem;

/**
 * 
 * @author Rajesh
 *
 */
public interface OrderItemBusinessService {

	
	  public Order createOrder(Order order);
	  
	  public Order getOrderById(Long id);
	  
	  public OrderItem getOrderItemById(Long id);
	 
}
