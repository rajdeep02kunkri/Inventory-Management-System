package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Purchase_details;
import com.rk.InventoryManager.repository.Purchase_detailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Purchase_detailsServiceImpl implements Purchase_detailsService {

    private final Purchase_detailsRepo Purchase_detailsRepo;

    @Autowired
    public Purchase_detailsServiceImpl(Purchase_detailsRepo Purchase_detailsRepo) {
        this.Purchase_detailsRepo = Purchase_detailsRepo;
    }

    @Transactional
    @Override
    public List<Purchase_details> getAllPurchase_details() {
        return Purchase_detailsRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Purchase_details> getPurchase_detailsById(Long id) {
        return Purchase_detailsRepo.findById(id);
    }

    @Transactional
    @Override
    public Purchase_details savePurchase_details(Purchase_details Purchase_details) {
        return Purchase_detailsRepo.save(Purchase_details);
    }

    @Transactional
    @Override
    public void deletePurchase_details(Long id) {
        Purchase_detailsRepo.deleteById(id);
    }
}
