package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Order_details {
    @Id
    @Min(value = 1, message = "Order details Id must be greater than 0")
    private long order_details_id;

    @NotNull(message = "Order ID must not be null")
    @Min(value = 1, message = "Order Id must be greater than 0")
    private long order_id;

    @Min(value = 1, message = "Medicine Id must be greater than 0")
    @NotNull(message = "Medicine ID must not be null")
    private long medicine_id;

    @Min(value = 1, message = "Quantity ordered must be greater than 0")
    @NotNull(message = "Quantity ordered must not be null")
    private long quantity_ordered;

    @Positive(message = "Unit price must be a positive value")
    private double unit_price;

    public Order_details(long order_details_id, long order_id, long medicine_id, long quantity_ordered, double unit_price) {
        this.order_details_id = order_details_id;
        this.order_id = order_id;
        this.medicine_id = medicine_id;
        this.quantity_ordered = quantity_ordered;
        this.unit_price = unit_price;
    }

    public Order_details() {
    }

    public long getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(long order_details_id) {
        this.order_details_id = order_details_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public long getQuantity_ordered() {
        return quantity_ordered;
    }

    public void setQuantity_ordered(long quantity_ordered) {
        this.quantity_ordered = quantity_ordered;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Order_details{" +
                "order_details_id=" + order_details_id +
                ", order_id=" + order_id +
                ", medicine_id=" + medicine_id +
                ", quantity_ordered=" + quantity_ordered +
                ", unit_price=" + unit_price +
                '}';
    }
}
