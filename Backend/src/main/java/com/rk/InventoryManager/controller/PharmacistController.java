package com.rk.InventoryManager.controller;

import com.rk.InventoryManager.model.Pharmacist;
import com.rk.InventoryManager.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/pharmacist")
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping("/")
    public ResponseEntity<List<Pharmacist>> getAllPharmacists() {
        List<Pharmacist> pharmacists = pharmacistService.getAllPharmacists();
        return new ResponseEntity<>(pharmacists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable("id") Long id) {
        Optional<Pharmacist> pharmacist = pharmacistService.getPharmacistById(id);
        return pharmacist.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Pharmacist> createPharmacist(@RequestBody Pharmacist pharmacist) {
        Pharmacist savedPharmacist = pharmacistService.savePharmacist(pharmacist);
        return new ResponseEntity<>(savedPharmacist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacist(@PathVariable("id") Long id) {
        pharmacistService.deletePharmacist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
