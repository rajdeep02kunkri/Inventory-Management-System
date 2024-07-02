package com.rk.InventoryManager.repository;

import com.rk.InventoryManager.model.Order_details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_detailsRepo extends JpaRepository<Order_details,Long> {
}
