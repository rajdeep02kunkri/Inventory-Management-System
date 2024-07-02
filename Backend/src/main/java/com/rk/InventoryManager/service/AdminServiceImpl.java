package com.rk.InventoryManager.service;


import com.rk.InventoryManager.exception.ResourceNotFoundException;
import com.rk.InventoryManager.model.Admin;
import com.rk.InventoryManager.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Transactional
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Admin> getAdminById(Long id) {
        Admin fetchedAdmin=adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin is not exist with the given id: "+id));
        return Optional.ofNullable(fetchedAdmin);
    }

    @Transactional
    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Transactional
    @Override
    public void deleteAdmin(Long id) {
        Admin fetchedAdmin=adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin is not exist with the given id: "+id));
        adminRepo.deleteById(id);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Admin fetchedAdmin=adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin is not exist with the given id: "+id));
        fetchedAdmin.setContact_number(admin.getContact_number());
        fetchedAdmin.setEmail_id(admin.getEmail_id());
        fetchedAdmin.setPassword(admin.getPassword());
        fetchedAdmin.setUsername(admin.getUsername());
        fetchedAdmin.setOther_details(admin.getOther_details());
        return adminRepo.save(fetchedAdmin);

    }
}
