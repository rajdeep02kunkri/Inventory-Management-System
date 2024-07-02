package com.rk.InventoryManager.repository;

import com.rk.InventoryManager.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepo extends JpaRepository<Pharmacist,Long> {
}
