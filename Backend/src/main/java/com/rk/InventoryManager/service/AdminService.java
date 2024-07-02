package com.rk.InventoryManager.service;



import com.rk.InventoryManager.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAllAdmins();

    Optional<Admin> getAdminById(Long id);

    Admin saveAdmin(Admin admin);

    void deleteAdmin(Long id);

    Admin updateAdmin(Long id,Admin admin);
}
