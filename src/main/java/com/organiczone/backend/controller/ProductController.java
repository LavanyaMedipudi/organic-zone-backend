package com.college.organiczone_backend.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.college.organiczone_backend.dto.ProductRequestDTO;
import com.college.organiczone_backend.model.Product;
import com.college.organiczone_backend.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product addProduct(@Valid @RequestBody ProductRequestDTO dto) {

    return productRepository
        .findByNameAndCategoryAndFarmerEmail(
            dto.getName(),
            dto.getCategory(),
            dto.getFarmerEmail()
        )
        .map(existingProduct -> {
            // Increase quantity
            existingProduct.setQuantity(
                existingProduct.getQuantity() + dto.getQuantity()
            );

            // update price
            existingProduct.setPrice(dto.getPrice());

            return productRepository.save(existingProduct);
        })
        .orElseGet(() -> {
            // Create new product
            Product product = new Product();
            product.setName(dto.getName());
            product.setCategory(dto.getCategory());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            product.setFarmerEmail(dto.getFarmerEmail());

            return productRepository.save(product);
        });
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}


