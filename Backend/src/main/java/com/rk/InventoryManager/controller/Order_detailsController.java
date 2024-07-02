package com.rk.InventoryManager.controller;

import com.rk.InventoryManager.model.Order_details;
import com.rk.InventoryManager.service.Order_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/order-details")
public class Order_detailsController {

    @Autowired
    private Order_detailsService Order_detailsService;

    @GetMapping("/")
    public ResponseEntity<List<Order_details>> getAllOrder_details() {
        List<Order_details> Order_details = Order_detailsService.getAllOrder_details();
        return new ResponseEntity<>(Order_details, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order_details> getOrder_detailsById(@PathVariable("id") Long id) {
        Optional<Order_details> Order_details = Order_detailsService.getOrder_detailsById(id);
        return Order_details.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Order_details> createOrder_details(@RequestBody Order_details Order_details) {
        Order_details savedOrder_details = Order_detailsService.saveOrder_details(Order_details);
        return new ResponseEntity<>(savedOrder_details, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder_details(@PathVariable("id") Long id) {
        Order_detailsService.deleteOrder_details(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
