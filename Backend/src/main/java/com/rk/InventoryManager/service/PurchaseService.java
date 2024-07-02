package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<Purchase> getAllPurchases();

    Optional<Purchase> getPurchaseById(Long id);

    Purchase savePurchase(Purchase purchase);

    void deletePurchase(Long id);
}
