package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<Medicine> getAllMedicines();

    Optional<Medicine> getMedicineById(Long id);

    Medicine saveMedicine(Medicine medicine);

    void deleteMedicine(Long id);
}
