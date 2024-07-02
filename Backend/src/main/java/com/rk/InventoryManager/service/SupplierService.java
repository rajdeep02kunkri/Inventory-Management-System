package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getAllSuppliers();

    Optional<Supplier> getSupplierById(Long id);

    Supplier saveSupplier(Supplier supplier);

    void deleteSupplier(Long id);
}
