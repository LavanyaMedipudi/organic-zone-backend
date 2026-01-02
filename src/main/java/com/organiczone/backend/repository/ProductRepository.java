package com.college.organiczone_backend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.college.organiczone_backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByFarmerEmail(String farmerEmail);

    List<Product> findByQuantityGreaterThan(int quantity);

    Optional<Product> findByNameAndCategoryAndFarmerEmail(
    String name,
    String category,
    String farmerEmail
    );
}
