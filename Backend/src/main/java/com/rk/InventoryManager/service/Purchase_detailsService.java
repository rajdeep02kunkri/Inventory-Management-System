package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Purchase_details;

import java.util.List;
import java.util.Optional;

public interface Purchase_detailsService {
    List<Purchase_details> getAllPurchase_details();

    Optional<Purchase_details> getPurchase_detailsById(Long id);

    Purchase_details savePurchase_details(Purchase_details purchase_details);

    void deletePurchase_details(Long id);
}
