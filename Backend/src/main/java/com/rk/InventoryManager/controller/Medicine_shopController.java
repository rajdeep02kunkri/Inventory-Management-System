package com.rk.InventoryManager.controller;

import com.rk.InventoryManager.model.Medicine_shop;
import com.rk.InventoryManager.service.Medicine_shopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicine-shop")
public class Medicine_shopController {

    @Autowired
    private Medicine_shopService medicine_shopService;

    @GetMapping("/")
    public ResponseEntity<List<Medicine_shop>> getAllMedicine_shops() {
        List<Medicine_shop> medicine_shops = medicine_shopService.getAllMedicine_shops();
        return new ResponseEntity<>(medicine_shops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine_shop> getMedicine_shopById(@PathVariable("id") Long id) {
        Optional<Medicine_shop> medicine_shop = medicine_shopService.getMedicine_shopById(id);
        return medicine_shop.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Medicine_shop> createMedicine_shop(@RequestBody Medicine_shop medicine_shop) {
        Medicine_shop savedMedicine_shop = medicine_shopService.saveMedicine_shop(medicine_shop);
        return new ResponseEntity<>(savedMedicine_shop, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine_shop(@PathVariable("id") Long id) {
        medicine_shopService.deleteMedicine_shop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine_shop> updateMedicine_shopInfo(@PathVariable("id") Long id, @RequestBody Medicine_shop medicine_shop) {
        Medicine_shop updatedMedicine_shop = medicine_shopService.updateMedicine_shop(id, medicine_shop);
        return new ResponseEntity<>(updatedMedicine_shop, HttpStatus.OK);
    }
}
