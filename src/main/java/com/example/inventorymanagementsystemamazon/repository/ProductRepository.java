package com.example.inventorymanagementsystemamazon.repository;

import com.example.inventorymanagementsystemamazon.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepository {

    HashMap<Product, Integer> productToMap;
    public Product save(Product product) {
        return null;
    }

    public Product findById(String productId) {
        return null;
    }

    public void delete(String productId) {
    }
}