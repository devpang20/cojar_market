package com.cojar.market.order.service;

import com.cojar.market.order.entity.Order;
import com.cojar.market.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void save(Order order) {
        this.orderRepository.save(order);
    }
}
