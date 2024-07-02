package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;

@Entity
public class Batch {
    @Id
    @Min(value = 1, message = "Batch Id must be greater than 0")
    private long batch_id;

    @NotBlank(message = "Batch number must not be blank")
    @Length(max = 255, message = "Batch number must be at most 45 characters long")
    private String batch_number;

    @NotNull(message = "Medicine ID must not be null")
    @Min(value = 1, message = "Medicine ID must be greater than 0")
    private long medicine_id;

    @NotNull(message = "Date must not be null")
    private Date manufacturing_date;

    @NotNull(message = "Date must not be null")
    private Date expiration_date;

    @Min(value = 0, message = "Quantity available must not be negative")
    private long quantity_available;

    public Batch(long batch_id,  String batch_number, long medicine_id, Date manufacturing_date, Date expiration_date, long quantity_available) {
        this.batch_id = batch_id;
        this.batch_number = batch_number;
        this.medicine_id = medicine_id;
        this.manufacturing_date = manufacturing_date;
        this.expiration_date = expiration_date;
        this.quantity_available = quantity_available;
    }

    public Batch() {
    }

    public long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(long batch_id) {
        this.batch_id = batch_id;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public Date getManufacturing_date() {
        return manufacturing_date;
    }

    public void setManufacturing_date(Date manufacturing_date) {
        this.manufacturing_date = manufacturing_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public long getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(long quantity_available) {
        this.quantity_available = quantity_available;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batch_id=" + batch_id +
                ", batch_number=" + batch_number +
                ", medicine_id=" + medicine_id +
                ", manufacturing_date=" + manufacturing_date +
                ", expiration_date=" + expiration_date +
                ", quantity_available=" + quantity_available +
                '}';
    }
}
