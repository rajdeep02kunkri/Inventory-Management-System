package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

@Entity
public class Purchase {
    @Id
    @Min(value = 1, message = "Purchase Id must be greater than 0")
    private long purchase_id;

    @NotNull(message = "Order ID must not be null")
    @Min(value = 1, message = "Order Id must be greater than 0")
    private long order_id;

    @NotNull(message = "Date must not be null")
    @PastOrPresent(message = "Purchase date must be in the past or present")
    private Date purchase_date;

    @Positive(message = "Total amount must be a positive value")
    private double total_amount;

    public Purchase(long purchase_id, long order_id, Date purchase_date, double total_amount) {
        this.purchase_id = purchase_id;
        this.order_id = order_id;
        this.purchase_date = purchase_date;
        this.total_amount = total_amount;
    }

    public Purchase() {
    }

    public long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchase_id=" + purchase_id +
                ", order_id=" + order_id +
                ", purchase_date=" + purchase_date +
                ", total_amount=" + total_amount +
                '}';
    }
}
