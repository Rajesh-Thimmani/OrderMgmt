package com.order.item.service.business;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.order.item.service.enums.ErrorCodes;
import com.order.item.service.exceptionhandler.OrderItemNotFound;
import com.order.item.service.exceptionhandler.OrderNotFoundException;
import com.order.item.service.model.ErrorDetails;
import com.order.item.service.model.Order;
import com.order.item.service.model.OrderItem;
import com.order.item.service.repository.OrderItemRepository;
import com.order.item.service.repository.OrderRepository;

/**
 * 
 * @author Rajesh
 *
 */

@Service("orderItemBusinessService")
public class OrderItemBusinessServiceImpl implements OrderItemBusinessService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;	

	/**
	 * create the order
	 */
	@Override
	@Transactional
	public Order createOrder(Order order) {
		Order orderResponse = null;
		try {
			Set<OrderItem> orderItemSet = 	order.getOrderItem();
			
			if(!CollectionUtils.isEmpty(orderItemSet)) {
				orderItemSet.forEach(item -> {
					item.setOrder(order);
				});
			}
			orderResponse = orderRepository.save(order);
		}catch(Exception exception) {
			throw exception;
		}
		return orderResponse;
	}


	/**
	 * get the order details by id
	 */
	@Override
	@Transactional
	public Order getOrderById(Long id) {
		Optional<Order> isOrder = orderRepository.findById(id);
		if (isOrder.isPresent()) {
			return isOrder.get();
		} else {
			throw new OrderNotFoundException(new ErrorDetails(ErrorCodes.R001));
		}
	}

	/**
	 *  Get the oder items by id
	 *  
	 * @param id
	 * @return
	 */
	@Transactional
	public OrderItem getOrderItemById(Long id) {
		OrderItem orderItem = null;
		Optional<OrderItem> isOrderItem = orderItemRepository.findById(id);
		if(isOrderItem.isPresent()) {
			orderItem = isOrderItem.get();
		}else {
			throw new OrderItemNotFound(new ErrorDetails(ErrorCodes.ORI001));
		}
		return orderItem;
	}
}
