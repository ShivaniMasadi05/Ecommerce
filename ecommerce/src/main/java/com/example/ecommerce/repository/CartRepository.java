package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.AddToCart;

public interface CartRepository extends JpaRepository<AddToCart, Long> {
    List<AddToCart> findByUserId(Long userId);
}
