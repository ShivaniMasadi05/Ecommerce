package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpRepository extends JpaRepository<SignUp, Long> {
   
    Optional<SignUp> findByEmailAndPassword(String email, String password);
}
