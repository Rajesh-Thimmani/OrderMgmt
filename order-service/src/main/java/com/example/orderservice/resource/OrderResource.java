package com.example.orderservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.intf.OrderService;

/**
 * 
 * @author Rajesh
 *
 */

@RestController
@RequestMapping("order-service")
public class OrderResource {

	@Autowired
	private OrderService orderService;
	
	

	/**
	 * create order.
	 * 
	 * @param odrerDTO
	 * @return
	 */
	@PostMapping("/create/order")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
		return ResponseEntity.ok().body(orderService.createOrder(orderDTO));
	}
	
	/**
	 * get the order by id
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
		
		@GetMapping("/orderid/{id}")
		public ResponseEntity<OrderDTO> getOrderByOrderId(@PathVariable("id") Long id){
			return ResponseEntity.ok().body(orderService.getOrderById(id));
		}
	
	
	/**
	 * get All order list
	 * 
	 * @return
	 */
	@GetMapping("all/orders")
	public ResponseEntity<List<OrderDTO>> getAllOrdersList(){
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}

}
