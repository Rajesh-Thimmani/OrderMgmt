package com.example.orderservice.intf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.OrderItemDTO;
import com.example.orderservice.exception.ErrorInCreatingOrder;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.model.Order;
import com.example.orderservice.proxy.OrderItemServiceProxy;
import com.example.orderservice.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemServiceProxy orderItemServiceProxy;

	/**
	 * create the order.
	 * 
	 */

	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		order = orderRepository.save(order);
		if (null != order) {
			BeanUtils.copyProperties(order, orderDTO);
			if (!CollectionUtils.isEmpty(orderDTO.getOrderItemDTOs())) {
				List<OrderItemDTO> itemDTOList = new ArrayList<>();
				for(OrderItemDTO itemDTO: orderDTO.getOrderItemDTOs()) {
					ResponseEntity<OrderItemDTO> orderItemDTO = orderItemServiceProxy.createOrderItem(itemDTO);
					if (null != orderItemDTO) {
						itemDTOList.add(orderItemDTO.getBody());
					}
				}
				orderDTO.setOrderItemDTOs(itemDTOList);
			}
		} else {
			throw new ErrorInCreatingOrder("unable to create the order");
		}

		return orderDTO;
	}

	/**
	 * get Order by Id.
	 * 
	 * @throws Exception
	 * 
	 */
	@Override
	public OrderDTO getOrderById(Long id) {
		OrderDTO orderDTO = new OrderDTO();
		Order order = orderRepository.findByOrderId(id);
		if (null != order) {
			BeanUtils.copyProperties(order, orderDTO);
			//client call
			ResponseEntity<List<OrderItemDTO>> responseEntity = orderItemServiceProxy.getOrderByOrderId(order.getOrderId());
			if(null != responseEntity) {
				orderDTO.setOrderItemDTOs(responseEntity.getBody());
			}
		} else {
			throw new OrderNotFoundException("No order item found");
		}
		return orderDTO;
	}

	/**
	 * get All orders.
	 * 
	 */
	@Override
	public List<OrderDTO> getAllOrders() {
		List<OrderDTO> orderDTOList = new ArrayList<>();
		List<Order> orderList = orderRepository.findAll();
		if (!CollectionUtils.isEmpty(orderList)) {
			orderList.forEach(order -> {
				OrderDTO orderDTO = new OrderDTO();
				BeanUtils.copyProperties(order, orderDTO);
				orderDTOList.add(orderDTO);
			});
			BeanUtils.copyProperties(orderList, orderDTOList);
		} else {
			throw new OrderNotFoundException("No order item found");
		}
		return orderDTOList;
	}

}
