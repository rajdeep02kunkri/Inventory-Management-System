package com.rk.InventoryManager.repository;

import com.rk.InventoryManager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
