package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.*;
import com.rk.InventoryManager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    private final BatchRepo batchRepo;

    @Autowired
    public BatchServiceImpl(BatchRepo batchRepo) {
        this.batchRepo = batchRepo;
    }

    @Transactional
    @Override
    public List<Batch> getAllBatches() {
        return batchRepo.findAll();
    }

    @Transactional
    @Override
    public Optional<Batch> getBatchById(Long id) {
        return batchRepo.findById(id);
    }

    @Transactional
    @Override
    public Batch saveBatch(Batch batch) {
        return batchRepo.save(batch);
    }

    @Transactional
    @Override
    public void deleteBatch(Long id) {
        batchRepo.deleteById(id);
    }
}

