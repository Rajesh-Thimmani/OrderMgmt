package com.order.item.service.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.item.service.model.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
