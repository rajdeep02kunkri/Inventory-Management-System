package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Medicine;
import com.rk.InventoryManager.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepo medicineRepo;

    @Autowired
    public MedicineServiceImpl(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    @Transactional
    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Medicine> getMedicineById(Long id) {
        return medicineRepo.findById(id);
    }

    @Transactional
    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    @Transactional
    @Override
    public void deleteMedicine(Long id) {
        medicineRepo.deleteById(id);
    }
}
