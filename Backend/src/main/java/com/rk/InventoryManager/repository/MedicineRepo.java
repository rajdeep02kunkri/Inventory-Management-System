package com.rk.InventoryManager.repository;

import com.rk.InventoryManager.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine,Long> {
}
