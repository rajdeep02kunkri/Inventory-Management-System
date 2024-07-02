package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Purchase;
import com.rk.InventoryManager.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Transactional
    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Purchase> getPurchaseById(Long id) {
        return purchaseRepo.findById(id);
    }

    @Transactional
    @Override
    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepo.save(purchase);
    }

    @Transactional
    @Override
    public void deletePurchase(Long id) {
        purchaseRepo.deleteById(id);
    }
}
