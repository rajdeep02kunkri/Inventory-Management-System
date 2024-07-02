package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Medicine_shop {
    @Id
    @Min(value = 1, message = "Medicine shop Id must be greater than 0")
    private long shop_id;

    @NotBlank(message = "Shop name is required")
    @Length(max = 255, message = "Shop name must be at most 255 characters long")
    private String shop_name;

    @NotBlank(message = "Address is required")
    @Length(max = 255, message = "Address must be at most 255 characters long")
    private String address;

    @Length(min = 10, max = 10, message = "Contact number must be exactly 10 digits long")
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d+", message = "Contact number must contain only digits")
    private String contact_number;

    @Length(max = 255, message = "Email must be at most 255 characters long")
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email_id;

    @Length(max = 255, message = "Other details must be at most 255 characters long")
    private String other_details;

    public Medicine_shop(long shop_id, String shop_name, String address, String contact_number, String email_id, String other_details) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.address = address;
        this.contact_number = contact_number;
        this.email_id = email_id;
        this.other_details = other_details;
    }

    public Medicine_shop() {
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @Override
    public String toString() {
        return "Medicine_shop{" +
                "shop_id=" + shop_id +
                ", shop_name='" + shop_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", email_id='" + email_id + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
