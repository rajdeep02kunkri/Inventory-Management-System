package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

    Order saveOrder(Order order);

    void deleteOrder(Long id);
}
