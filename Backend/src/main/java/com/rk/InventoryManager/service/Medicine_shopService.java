
package com.rk.InventoryManager.service;
import com.rk.InventoryManager.model.Admin;
import com.rk.InventoryManager.model.Medicine_shop;
import java.util.List;
import java.util.Optional;

public interface Medicine_shopService {
    List<Medicine_shop> getAllMedicine_shops();

    Optional<Medicine_shop> getMedicine_shopById(Long id);

    Medicine_shop saveMedicine_shop(Medicine_shop medicine_shop);

    void deleteMedicine_shop(Long id);

    Medicine_shop updateMedicine_shop(Long id, Medicine_shop mshop);

}
