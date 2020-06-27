package com.order.item.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.item.service.business.OrderItemBusinessService;
import com.order.item.service.dto.OrderItemDTO;

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
	 * 
	 * @param order
	 * @return
	 */
	
	@PostMapping(value = "/create/order/item")
	public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
		// service call
		return ResponseEntity.ok().body(orderItemBusinessService.createOrderItem(orderItemDTO));
	}

	/**
	 * get the order details by id
	 * 
	 * @param id
	 * @return
	 */
	
	@GetMapping(value = "/orderItem/{id}")
	public ResponseEntity<OrderItemDTO> getOrderById(@PathVariable("id") Long id) {
		// service call
		return ResponseEntity.ok().body(orderItemBusinessService.getOrderItemById(id));
	}

	/**
	 * get All order items.
	 * 
	 * @param id
	 * @return
	 */
	
	@GetMapping(value = "/all/orderItems")
	public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
		// service call
		return ResponseEntity.ok().body(orderItemBusinessService.getOrderAllOrderItems());
	}
	
	/**
	 * get the order item details by order id
	 * 
	 * @param orderId
	 * @return
	 */
	
	@GetMapping(value="/orderId/{id}")
	public ResponseEntity<List<OrderItemDTO>> getOrderItemByOrderId(Long id){
		return ResponseEntity.ok().body(orderItemBusinessService.getOrderItemByOrderId(id));
	}

}
