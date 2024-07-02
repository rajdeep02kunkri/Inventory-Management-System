package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    List<Manager> getAllManagers();

    Optional<Manager> getManagerById(Long id);

    Manager saveManager(Manager manager);

    void deleteManager(Long id);
}
