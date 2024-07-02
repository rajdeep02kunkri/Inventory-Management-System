package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;


@Entity
public class Pharmacist {
    @Id
    @Min(value = 1, message = "Pharmacist Id must be greater than 0")
    private long pharmacist_id;

    @NotNull(message = "Shop ID is required")
    @Min(value = 1, message = "Shop Id must be greater than 0")
    private long shop_id;

    @NotBlank(message = "Pharmacist name is required")
    @Length(max = 255, message = "Pharmacist name must be at most 255 characters long")
    private String pharmacist_name;

    @NotBlank(message = "Role is required")
    @Length(max = 45, message = "Role be at most 45 characters long")
    private String role;

    @NotBlank(message = "Contact number is required")
    @Length(min = 10, max = 10, message = "Contact number must be exactly 10 characters long")
    @Pattern(regexp = "\\d+", message = "Contact number must contain only digits")
    private String contact_number;

    @NotBlank(message = "Email is required")
    @Length(max = 255, message = "Email must be at most 255 characters long")
    @Email(message = "Invalid email format")
    private String email_id;

    @NotBlank(message = "Username is required")
    @Length(max = 45, message = "Username must be at most 45 characters long")
    private String username;

    @NotBlank(message = "Password is required")
    @Length(max = 45, message = "Password must be at most 45 characters long")
    private String password;

    @Length(max = 255, message = "Other details must be at most 255 characters long")
    private String other_details;

    public Pharmacist() {
    }

    public Pharmacist(long pharmacist_id, long shop_id, String pharmacist_name, String role, String contact_number, String email_id, String username, String password, String other_details) {
        this.pharmacist_id = pharmacist_id;
        this.shop_id = shop_id;
        this.pharmacist_name = pharmacist_name;
        this.role = role;
        this.contact_number = contact_number;
        this.email_id = email_id;
        this.username = username;
        this.password = password;
        this.other_details = other_details;
    }

    public long getPharmacist_id() {
        return pharmacist_id;
    }

    public void setPharmacist_id(long pharmacist_id) {
        this.pharmacist_id = pharmacist_id;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getPharmacist_name() {
        return pharmacist_name;
    }

    public void setPharmacist_name(String pharmacist_name) {
        this.pharmacist_name = pharmacist_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @Override
    public String toString() {
        return "Pharmacist{" +
                "pharmacist_id=" + pharmacist_id +
                ", shop_id=" + shop_id +
                ", pharmacist_name='" + pharmacist_name + '\'' +
                ", role='" + role + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", email_id='" + email_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
