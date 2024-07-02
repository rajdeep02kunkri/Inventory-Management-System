package com.rk.InventoryManager.service;

import com.rk.InventoryManager.exception.ResourceNotFoundException;
import com.rk.InventoryManager.model.Medicine_shop;
import com.rk.InventoryManager.repository.Medicine_shopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Medicine_shopServiceImpl implements Medicine_shopService {

    private final Medicine_shopRepo medicine_shopRepo;

    @Autowired
    public Medicine_shopServiceImpl(Medicine_shopRepo medicine_shopRepo) {
        this.medicine_shopRepo = medicine_shopRepo;
    }

    @Transactional
    @Override
    public List<Medicine_shop> getAllMedicine_shops() {
        return medicine_shopRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Medicine_shop> getMedicine_shopById(Long id) {
        return medicine_shopRepo.findById(id);
    }

    @Transactional
    @Override
    public Medicine_shop saveMedicine_shop(Medicine_shop Medicine_shop) {
        return medicine_shopRepo.save(Medicine_shop);
    }

    @Transactional
    @Override
    public void deleteMedicine_shop(Long id) {
        medicine_shopRepo.deleteById(id);
    }

    @Override
    public Medicine_shop updateMedicine_shop(Long id, Medicine_shop mshop) {
        Medicine_shop fetchedMedicine_shop=medicine_shopRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medicine Shop does not exist with the given id: "+id));
        fetchedMedicine_shop.setShop_name(mshop.getShop_name());
        fetchedMedicine_shop.setContact_number(mshop.getContact_number());
        fetchedMedicine_shop.setAddress(mshop.getAddress());
        fetchedMedicine_shop.setEmail_id(mshop.getEmail_id());
        fetchedMedicine_shop.setOther_details(mshop.getOther_details());
        return medicine_shopRepo.save(fetchedMedicine_shop);
    }
}
