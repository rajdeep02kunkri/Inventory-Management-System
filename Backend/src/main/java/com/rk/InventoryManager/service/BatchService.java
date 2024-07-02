package com.rk.InventoryManager.service;

import com.rk.InventoryManager.model.Batch;

import java.util.List;
import java.util.Optional;

public interface BatchService {
    List<Batch> getAllBatches();

    Optional<Batch> getBatchById(Long id);

    Batch saveBatch(Batch batch);

    void deleteBatch(Long id);
}
