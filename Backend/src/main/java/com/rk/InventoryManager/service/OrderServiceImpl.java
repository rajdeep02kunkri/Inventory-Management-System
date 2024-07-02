package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Order;
import com.rk.InventoryManager.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Transactional
    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepo.findById(id);
    }

    @Transactional
    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    @Transactional
    @Override
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}
