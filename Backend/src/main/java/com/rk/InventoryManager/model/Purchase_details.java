package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Purchase_details {
    @Id
    @Min(value = 1, message = "Purchase details Id must be greater than 0")
    private long purchase_details_id;

    @NotNull(message = "Purchase ID must not be null")
    @Min(value = 1, message = "Purchase Id must be greater than 0")
    private long purchase_id;

    @NotNull(message = "Medicine ID must not be null")
    @Min(value = 1, message = "Medicine ID must be greater than 0")
    private long medicine_id;

    @Min(value = 1, message = "Quantity purchased must be greater than 0")
    @NotNull(message = "Quantity purchased must not be null")
    private long quantity_purchased;

    @Positive(message = "Unit price must be a positive value")
    private double unit_price;

    public Purchase_details(long purchase_details_id, long purchase_id, long medicine_id, long quantity_purchased, double unit_price) {
        this.purchase_details_id = purchase_details_id;
        this.purchase_id = purchase_id;
        this.medicine_id = medicine_id;
        this.quantity_purchased = quantity_purchased;
        this.unit_price = unit_price;
    }

    public Purchase_details() {
    }

    public long getPurchase_details_id() {
        return purchase_details_id;
    }

    public void setPurchase_details_id(long purchase_details_id) {
        this.purchase_details_id = purchase_details_id;
    }

    public long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public long getQuantity_purchased() {
        return quantity_purchased;
    }

    public void setQuantity_purchased(long quantity_purchased) {
        this.quantity_purchased = quantity_purchased;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Purchase_details{" +
                "purchase_details_id=" + purchase_details_id +
                ", purchase_id=" + purchase_id +
                ", medicine_id=" + medicine_id +
                ", quantity_purchased=" + quantity_purchased +
                ", unit_price=" + unit_price +
                '}';
    }
}
