package com.order.item.service.business;

import java.util.List;

import com.order.item.service.dto.OrderItemDTO;

/**
 * 
 * @author Rajesh
 *
 */
public interface OrderItemBusinessService {
	
	  public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);
	  
	  public OrderItemDTO getOrderItemById(Long id);
	  
	  public List<OrderItemDTO> getOrderAllOrderItems();	
	  
	  public List<OrderItemDTO> getOrderItemByOrderId(Long id);
	 
}
