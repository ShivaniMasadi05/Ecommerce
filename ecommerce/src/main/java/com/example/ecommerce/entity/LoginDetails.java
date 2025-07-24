package com.example.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class LoginDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    private Long id;

    private String email;
    private String password;

    // Constructors
    public LoginDetails() {}

    public LoginDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
