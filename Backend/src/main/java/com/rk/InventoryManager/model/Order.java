package com.rk.InventoryManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.sql.Date;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false, updatable = false)
    @Min(value = 1, message = "Order Id must be greater than 0")
    private long order_id;

    @Min(value = 1, message = "Supplier Id must be greater than 0")
    @NotNull(message = "Supplier ID must not be null")
    private long supplier_id;

    @NotNull(message = "Date must not be null")
    @PastOrPresent(message = "Order date date must be in the past or present")
    private Date order_date;

    @NotNull(message = "Date must not be null")
    private Date expected_delivery_date;


    @NotNull(message = "Order Status must not be null")
    @Enumerated(EnumType.STRING)
    private Order_status status;


    public Order(long order_id, long supplier_id, Date order_date, Date expected_delivery_date, Order_status status) {
        this.order_id = order_id;
        this.supplier_id = supplier_id;
        this.order_date = order_date;
        this.expected_delivery_date = expected_delivery_date;
        this.status = status;
    }

    public Order() {
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public void setExpected_delivery_date(Date expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }

    public Order_status getStatus() {
        return status;
    }

    public void setStatus(Order_status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", supplier_id=" + supplier_id +
                ", order_date=" + order_date +
                ", expected_delivery_date=" + expected_delivery_date +
                ", status=" + status +
                '}';
    }
}
