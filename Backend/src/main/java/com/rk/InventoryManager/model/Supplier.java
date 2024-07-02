package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Supplier {
    @Id
    @Min(value = 1, message = "Supplier Id must be greater than 0")
    private int supplier_id;

    @NotBlank(message = "Supplier name is required")
    @Length(max = 255, message = "Supplier name must be at most 255 characters long")
    private String supplier_name;

    @NotBlank(message = "Contact person is required")
    @Length(max = 255, message = "Contact person must be at most 255 characters long")
    private String contact_person;

    @NotBlank(message = "Contact number is required")
    @Length(min = 10, max = 10, message = "Contact number must be exactly 10 characters long")
    @Pattern(regexp = "\\d+", message = "Contact number must contain only digits")
    private String contact_number;

    @NotBlank(message = "Email is required")
    @Length(max = 255, message = "Email must be at most 255 characters long")
    @Email(message = "Invalid email format")
    private String email_id;

    @NotBlank(message = "Address is required")
    @Length(max = 255, message = "Address must be at most 255 characters long")
    private String address;

    @Length(max = 255, message = "Other details must be at most 255 characters long")
    private String other_details;

    public Supplier(int supplier_id, String supplier_name, String contact_person, String contact_number, String email_id, String address, String other_details) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.contact_person = contact_person;
        this.contact_number = contact_number;
        this.email_id = email_id;
        this.address = address;
        this.other_details = other_details;
    }

    public Supplier() {
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name + '\'' +
                ", contact_person='" + contact_person + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", email_id='" + email_id + '\'' +
                ", address='" + address + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
