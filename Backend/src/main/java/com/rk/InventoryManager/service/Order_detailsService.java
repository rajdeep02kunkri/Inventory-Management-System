package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Order_details;

import java.util.List;
import java.util.Optional;

public interface Order_detailsService {
    List<Order_details> getAllOrder_details();

    Optional<Order_details> getOrder_detailsById(Long id);

    Order_details saveOrder_details(Order_details order_details);

    void deleteOrder_details(Long id);
}
