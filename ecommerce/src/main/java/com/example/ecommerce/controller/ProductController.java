package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.SignUp;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.SignUpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repo; 

    

    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return repo.findById(id)
            .map(product -> ResponseEntity.ok().body(product))
            .orElse(ResponseEntity.notFound().build());
    }
    


    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody Product product) {
        Product saved = repo.save(product);
        ApiResponse response = new ApiResponse("Product Created Successfully", saved);
        return new ResponseEntity<>(response, HttpStatus.CREATED); // 201
    }    
   

	/*
	 * @PutMapping("/{id}") public Product updateProduct(@PathVariable Long
	 * id, @RequestBody Product p) { p.setId(id); return repo.save(p); }
	 */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long id, @RequestBody Product p) {
        p.setId(id);
        Product updatedProduct = repo.save(p);
        ApiResponse response = new ApiResponse("Product Updated Successfully", updatedProduct);
        return new ResponseEntity<>(response, HttpStatus.OK); // 200 OK
    }


	/*
	 * @PatchMapping("/{id}") public Product partialUpdate(@PathVariable Long
	 * id, @RequestBody Product p) { Product existing =
	 * repo.findById(id).orElseThrow(); if (p.getName() != null)
	 * existing.setName(p.getName()); if (p.getDescription() != null)
	 * existing.setDescription(p.getDescription()); if (p.getprice() != null)
	 * existing.setprice(p.getprice()); return repo.save(existing); }
	 */
    
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> partialUpdate(@PathVariable Long id, @RequestBody Product p) {
        Product existing = repo.findById(id).orElseThrow();

        if (p.getName() != null) existing.setName(p.getName());
        if (p.getDescription() != null) existing.setDescription(p.getDescription());
        if (p.getprice() != null) existing.setprice(p.getprice());

        Product updated = repo.save(existing);
        ApiResponse response = new ApiResponse("Product Partially Updated Successfully", updated);
        return new ResponseEntity<>(response, HttpStatus.OK); // 200 OK
    }

	/*
	 * @DeleteMapping("/{id}") public void deleteProduct(@PathVariable Long id) {
	 * repo.deleteById(id); }
	 */
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return new ResponseEntity<>(new ApiResponse("Product not found", null), HttpStatus.NOT_FOUND);
        }

        repo.deleteById(id);
        ApiResponse response = new ApiResponse("Product deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
