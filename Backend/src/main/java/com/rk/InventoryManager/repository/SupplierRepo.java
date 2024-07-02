package com.rk.InventoryManager.repository;


import com.rk.InventoryManager.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier,Long> {
}
