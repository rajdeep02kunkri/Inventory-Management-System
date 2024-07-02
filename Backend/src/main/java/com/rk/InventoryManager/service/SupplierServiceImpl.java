package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Supplier;
import com.rk.InventoryManager.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepo supplierRepo;

    @Autowired
    public SupplierServiceImpl(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Transactional
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepo.findById(id);
    }

    @Transactional
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Transactional
    @Override
    public void deleteSupplier(Long id) {
        supplierRepo.deleteById(id);
    }
}
