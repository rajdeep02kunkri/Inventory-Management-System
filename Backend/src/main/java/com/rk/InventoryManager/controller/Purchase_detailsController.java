package com.rk.InventoryManager.controller;

import com.rk.InventoryManager.model.Purchase_details;
import com.rk.InventoryManager.service.Purchase_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/purchase-details")
public class Purchase_detailsController {

    @Autowired
    private Purchase_detailsService Purchase_detailsService;

    @GetMapping("/")
    public ResponseEntity<List<Purchase_details>> getAllPurchase_details() {
        List<Purchase_details> Purchase_details = Purchase_detailsService.getAllPurchase_details();
        return new ResponseEntity<>(Purchase_details, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase_details> getPurchase_detailsById(@PathVariable("id") Long id) {
        Optional<Purchase_details> Purchase_details = Purchase_detailsService.getPurchase_detailsById(id);
        return Purchase_details.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Purchase_details> createPurchase_details(@RequestBody Purchase_details Purchase_details) {
        Purchase_details savedPurchase_details = Purchase_detailsService.savePurchase_details(Purchase_details);
        return new ResponseEntity<>(savedPurchase_details, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase_details(@PathVariable("id") Long id) {
        Purchase_detailsService.deletePurchase_details(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
