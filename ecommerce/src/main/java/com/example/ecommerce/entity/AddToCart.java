// src/main/java/com/example/ecommerce/entity/AddToCart.java
package com.example.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class AddToCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long productId;
    private String addedTime;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getAddedTime() { return addedTime; }
    public void setAddedTime(String addedTime) { this.addedTime = addedTime; }
}