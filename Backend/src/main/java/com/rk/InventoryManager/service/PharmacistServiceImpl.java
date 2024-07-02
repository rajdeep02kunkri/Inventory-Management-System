package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Pharmacist;
import com.rk.InventoryManager.repository.PharmacistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    private final PharmacistRepo pharmacistRepo;

    @Autowired
    public PharmacistServiceImpl(PharmacistRepo pharmacistRepo) {
        this.pharmacistRepo = pharmacistRepo;
    }

    @Transactional
    @Override
    public List<Pharmacist> getAllPharmacists() {
        return pharmacistRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Pharmacist> getPharmacistById(Long id) {
        return pharmacistRepo.findById(id);
    }

    @Transactional
    @Override
    public Pharmacist savePharmacist(Pharmacist pharmacist) {
        return pharmacistRepo.save(pharmacist);
    }

    @Transactional
    @Override
    public void deletePharmacist(Long id) {
        pharmacistRepo.deleteById(id);
    }
}
