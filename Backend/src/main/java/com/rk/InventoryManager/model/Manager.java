package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
public class Manager {
    @Id
    @Min(value = 1, message = "Manager Id must be greater than 0")
    private long manager_id;

    @NotNull(message = "Shop ID is required")
    @Min(value = 1, message = "Shop Id must be greater than 0")
    private long shop_id;

    @NotBlank(message = "Manager name is required")
    @Length(max = 255, message = "Manager name must be at most 255 characters long")
    private String manager_name;

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

    public Manager() {
    }

    public Manager(long manager_id, long shop_id, String manager_name, String contact_number, String email_id, String username, String password, String other_details) {
        this.manager_id = manager_id;
        this.shop_id = shop_id;
        this.manager_name = manager_name;
        this.contact_number = contact_number;
        this.email_id = email_id;
        this.username = username;
        this.password = password;
        this.other_details = other_details;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
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
        return "Manager{" +
                "manager_id=" + manager_id +
                ", shop_id=" + shop_id +
                ", manager_name='" + manager_name + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", email_id='" + email_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
