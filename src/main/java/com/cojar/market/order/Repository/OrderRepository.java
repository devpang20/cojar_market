package com.cojar.market.order.Repository;

import com.cojar.market.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<OrderItem, Long> {
}
