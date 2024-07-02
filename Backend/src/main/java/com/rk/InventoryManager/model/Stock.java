package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Stock {
    @Id
    @Min(value = 1, message = "Stock Id must be greater than 0")
    private long stock_id;

    @NotNull(message = "Medicine ID must not be null")
    @Min(value = 1, message = "Medicine ID must be greater than 0")
    private long medicine_id;

    @NotNull(message = "Quantity in stock must not be null")
    @Min(value = 1, message = "Quantity in stock must be greater than and equal to 0")
    private long quantity_in_stock;

    public Stock(long stock_id, long medicine_id, long quantity_in_stock) {
        this.stock_id = stock_id;
        this.medicine_id = medicine_id;
        this.quantity_in_stock = quantity_in_stock;
    }

    public Stock() {
    }

    public long getStock_id() {
        return stock_id;
    }

    public void setStock_id(long stock_id) {
        this.stock_id = stock_id;
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public long getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(long quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock_id=" + stock_id +
                ", medicine_id=" + medicine_id +
                ", quantity_in_stock=" + quantity_in_stock +
                '}';
    }
}
