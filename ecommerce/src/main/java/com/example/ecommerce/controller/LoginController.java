package com.example.ecommerce.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.ecommerce.entity.SignUp;
import com.example.ecommerce.repository.SignUpRepository;


@RestController


public class LoginController {

    @Autowired
    private SignUpRepository signUpRepo;
    
    @GetMapping("/users")
    public List<SignUp> getAllUsers() {
        return signUpRepo.findAll();
        
    }
    
    @GetMapping("/users/{id}")
    public ResponseEntity<SignUp> getUserById(@PathVariable Long id) {
        return signUpRepo.findById(id)
            .map(user -> ResponseEntity.ok().body(user))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody SignUp loginData) {
        Optional<SignUp> user = signUpRepo.findByEmailAndPassword(loginData.getEmail(), loginData.getPassword());
        
        if (user.isPresent()) {
            ApiResponse response = new ApiResponse("Login successful", user.get());
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(new ApiResponse("Invalid email or password", null), HttpStatus.UNAUTHORIZED);
        }
    }

    

}