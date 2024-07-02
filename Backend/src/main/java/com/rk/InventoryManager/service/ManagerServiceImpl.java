package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Manager;
import com.rk.InventoryManager.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepo managerRepo;

    @Autowired
    public ManagerServiceImpl(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    @Transactional
    @Override
    public List<Manager> getAllManagers() {
        return managerRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Manager> getManagerById(Long id) {
        return managerRepo.findById(id);
    }

    @Transactional
    @Override
    public Manager saveManager(Manager manager) {
        return managerRepo.save(manager);
    }

    @Transactional
    @Override
    public void deleteManager(Long id) {
        managerRepo.deleteById(id);
    }
}
