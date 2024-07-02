package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Order_details;
import com.rk.InventoryManager.repository.Order_detailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Order_detailsServiceImpl implements Order_detailsService {

    private final Order_detailsRepo Order_detailsRepo;

    @Autowired
    public Order_detailsServiceImpl(Order_detailsRepo Order_detailsRepo) {
        this.Order_detailsRepo = Order_detailsRepo;
    }

    @Transactional
    @Override
    public List<Order_details> getAllOrder_details() {
        return Order_detailsRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Order_details> getOrder_detailsById(Long id) {
        return Order_detailsRepo.findById(id);
    }

    @Transactional
    @Override
    public Order_details saveOrder_details(Order_details Order_details) {
        return Order_detailsRepo.save(Order_details);
    }

    @Transactional
    @Override
    public void deleteOrder_details(Long id) {
        Order_detailsRepo.deleteById(id);
    }
}
