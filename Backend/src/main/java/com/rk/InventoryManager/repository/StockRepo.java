package com.rk.InventoryManager.repository;

import com.rk.InventoryManager.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock,Long> {
}
