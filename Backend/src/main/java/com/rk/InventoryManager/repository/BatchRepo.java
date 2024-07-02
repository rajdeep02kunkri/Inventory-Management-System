package com.rk.InventoryManager.repository;


import com.rk.InventoryManager.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch,Long> {
}
