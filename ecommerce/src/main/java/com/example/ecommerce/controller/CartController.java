package com.example.ecommerce.controller;

import com.example.ecommerce.entity.AddToCart;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository repo;

    @PostMapping
    public AddToCart addToCart(@RequestBody AddToCart item) {
        item.setAddedTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return repo.save(item);
    }

    @GetMapping
    public List<AddToCart> viewCart(@RequestParam Long userId) {
        return repo.findByUserId(userId);
    }
}