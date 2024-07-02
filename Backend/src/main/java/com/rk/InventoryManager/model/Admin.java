package com.rk.InventoryManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Admin {
    @Id
    @Min(value = 1, message = "Admin Id must be greater than 0")
    private long admin_id;

    @Length(max = 45, message = "Username must be at most 45 characters long")
    @NotBlank(message = "Username is required")
    private String username;

    @Length(max = 45, message = "Password must be at most 45 characters long")
    @NotBlank(message = "Password is required")
    private String password;

    @Length(max = 255, message = "Email must be at most 255 characters long")
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email_id;

    @Length(min = 10, max = 10, message = "Contact number must be exactly 10 digits long")
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\d+", message = "Contact number must contain only digits")
    private String contact_number;

    @Length(max = 255, message = "Other details must be at most 255 characters long")
    private String other_details;

    public Admin(long admin_id, String username, String password, String email_id, String contact_number, String other_details) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
        this.email_id = email_id;
        this.contact_number = contact_number;
        this.other_details = other_details;
    }

    public Admin() {
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
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

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email_id='" + email_id + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", other_details='" + other_details + '\'' +
                '}';
    }
}
