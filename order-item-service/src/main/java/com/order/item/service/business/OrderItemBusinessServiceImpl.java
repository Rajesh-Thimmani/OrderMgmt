package com.order.item.service.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.order.item.service.dto.OrderItemDTO;
import com.order.item.service.exceptionhandler.ErrorInRetrievingDataException;
import com.order.item.service.exceptionhandler.OrderItemNotFound;
import com.order.item.service.exceptionhandler.UnableToCreateOrderItem;
import com.order.item.service.model.OrderItem;
import com.order.item.service.repository.OrderItemRepository;

/**
 * 
 * @author Rajesh
 *
 */

@Service("orderItemBusinessService")
public class OrderItemBusinessServiceImpl implements OrderItemBusinessService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	/**
	 * create the order
	 */
	@Override
	@Transactional
	public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
		OrderItem oderItem = new OrderItem();
		OrderItemDTO orderItemDTORes = new OrderItemDTO();
		try {
			if (null != orderItemDTO) {
				BeanUtils.copyProperties(orderItemDTO, oderItem);
				oderItem = orderItemRepository.save(oderItem);
				BeanUtils.copyProperties(oderItem, orderItemDTORes);
			}
		} catch (Exception exception) {
			throw new UnableToCreateOrderItem(exception.getMessage());
		}
		return orderItemDTORes;
	}

	/**
	 * will retrieve the order item by id
	 */
	@Override
	public OrderItemDTO getOrderItemById(Long id) {
		OrderItemDTO itemDTO = new OrderItemDTO();
		try {
			OrderItem orderItem = orderItemRepository.findByOrderItemId(id);
			if (null != orderItem) {
				BeanUtils.copyProperties(orderItem, itemDTO);
			} else {
				throw new OrderItemNotFound("No order items are available");
			}
		} catch (Exception exception) {
			throw new ErrorInRetrievingDataException(exception.getMessage());
		}
		return itemDTO;
	}

	/**
	 * get All order items
	 */
	@Override
	public List<OrderItemDTO> getOrderAllOrderItems() {
		List<OrderItemDTO> orderItemDTOList = null;
		List<OrderItem> orderItem = null;
		try {
			orderItem = orderItemRepository.findAll();
			if (!CollectionUtils.isEmpty(orderItem)) {
				orderItemDTOList = convertBOListTODTOList(orderItem);
			} else {
				throw new OrderItemNotFound("No order items are available");
			}
		} catch (Exception exception) {
			throw new ErrorInRetrievingDataException(exception.getMessage());
		}

		return orderItemDTOList;
	}

	/**
	 * get the order item details by order id
	 */
	@Override
	public List<OrderItemDTO> getOrderItemByOrderId(Long id) {
		List<OrderItemDTO> itemDTOList = null;
		List<OrderItem> orderItems = orderItemRepository.findByOrderId(id);

		if (!CollectionUtils.isEmpty(orderItems)) {
			itemDTOList = convertBOListTODTOList(orderItems);
		} else {
			throw new OrderItemNotFound("No order items are available with this order id");
		}
		return itemDTOList;
	}

	/**
	 * Method to convert the pojo to dto.
	 * 
	 * @param orderItems
	 * @return
	 */
	private List<OrderItemDTO> convertBOListTODTOList(List<OrderItem> orderItems) {
		List<OrderItemDTO> itemDTOList = new ArrayList<>();
		orderItems.forEach(item -> {
			OrderItemDTO itemDTO = new OrderItemDTO();
			BeanUtils.copyProperties(item, itemDTO);
			itemDTOList.add(itemDTO);
		});
		return itemDTOList;
	}
}
