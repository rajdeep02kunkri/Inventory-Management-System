package com.rk.InventoryManager.repository;

import com.rk.InventoryManager.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase,Long> {
}
