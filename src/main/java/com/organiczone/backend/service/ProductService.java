package com.college.organiczone_backend.service;

import java.util.List;
import com.college.organiczone_backend.dto.ProductRequestDTO;
import com.college.organiczone_backend.model.Product;

public interface ProductService {
    Product addProduct(ProductRequestDTO dto);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}


