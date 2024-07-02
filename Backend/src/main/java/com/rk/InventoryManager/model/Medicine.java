package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

@Entity
public class Medicine {
    @Id
    @Min(value = 1, message = "Medicine Id must be greater than 0")
    private long medicine_id;

    @NotBlank(message = "Medicine name is required")
    @Length(max = 255, message = "Medicine name must be at most 255 characters long")
    private String medicine_name;

    @NotBlank(message = "Description is required")
    private String description;


    @Positive(message = "Unit price must be a positive value")
    private double unit_price;


    @Min(value = 0, message = "Quantity in hand must be greater than or equal to 0")
    private long quantity_in_hand;

    @Min(value = 1, message = "Supplier id must be greater than 0")
    private long supplier_id;

    public Medicine(long medicine_id, String medicine_name, String description, Double unit_price, long quantity_in_hand, long supplier_id) {
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.description = description;
        this.unit_price = unit_price;
        this.quantity_in_hand = quantity_in_hand;
        this.supplier_id = supplier_id;
    }

    public Medicine() {
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public long getQuantity_in_hand() {
        return quantity_in_hand;
    }

    public void setQuantity_in_hand(long quantity_in_hand) {
        this.quantity_in_hand = quantity_in_hand;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicine_id=" + medicine_id +
                ", medicine_name='" + medicine_name + '\'' +
                ", description='" + description + '\'' +
                ", unit_price=" + unit_price +
                ", quantity_in_hand=" + quantity_in_hand +
                ", supplier_id=" + supplier_id +
                '}';
    }
}
