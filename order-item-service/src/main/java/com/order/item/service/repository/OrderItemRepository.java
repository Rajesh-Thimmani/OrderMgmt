package com.order.item.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.item.service.model.OrderItem;

/**
 * 
 * @author Rajesh
 *
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	OrderItem findByOrderItemId(Long orderItemId);
	List<OrderItem> findByOrderId(Long orderId);
}
