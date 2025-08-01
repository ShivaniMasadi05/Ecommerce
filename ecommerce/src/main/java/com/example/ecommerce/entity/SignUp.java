package com.example.ecommerce.entity;

import jakarta.persistence.*;


@Entity
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    
    private String email;
    private String password;
  

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
  
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
   
}