package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Pharmacist;

import java.util.List;
import java.util.Optional;

public interface PharmacistService {
    List<Pharmacist> getAllPharmacists();

    Optional<Pharmacist> getPharmacistById(Long id);

    Pharmacist savePharmacist(Pharmacist pharmacist);

    void deletePharmacist(Long id);
}
