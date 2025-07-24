package com.example.ecommerce.controller;



import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.SignUp;
import com.example.ecommerce.repository.SignUpRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private SignUpRepository repo;
    

    // GET: Get all users
    @GetMapping
    public List<SignUp> getAllUsers() {
        return repo.findAll();
    }
    
 // GET: Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<SignUp> getUserById(@PathVariable Long id) {
        return repo.findById(id)
            .map(user -> ResponseEntity.ok().body(user))
            .orElse(ResponseEntity.notFound().build());
    }

    // POST: Register a new user
    @PostMapping
    

    public ResponseEntity<ApiResponse> registerUser(@RequestBody SignUp user){
    	SignUp saved=repo.save(user);
    	Map<String, String> userData = new HashMap<>();
        userData.put("email", user.getEmail());
        userData.put("password", user.getPassword());
        ApiResponse response = new ApiResponse("Signup successful", userData);

        return new ResponseEntity<>(response, HttpStatus.CREATED); // 201
    } 
   
}
