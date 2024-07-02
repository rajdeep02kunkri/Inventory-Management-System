package com.rk.InventoryManager.repository;


import com.rk.InventoryManager.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager,Long> {
}
