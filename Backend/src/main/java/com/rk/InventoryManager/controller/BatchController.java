package com.rk.InventoryManager.controller;

import com.rk.InventoryManager.model.Batch;
import com.rk.InventoryManager.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping("/")
    public ResponseEntity<List<Batch>> getAllBatches() {
        List<Batch> batches = batchService.getAllBatches();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batch> getBatchById(@PathVariable("id") Long id) {
        Optional<Batch> batch = batchService.getBatchById(id);
        return batch.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        Batch savedBatch = batchService.saveBatch(batch);
        return new ResponseEntity<>(savedBatch, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable("id") Long id) {
        batchService.deleteBatch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
