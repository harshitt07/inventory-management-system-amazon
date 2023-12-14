package com.example.inventorymanagementsystemamazon.repository;

import com.example.inventorymanagementsystemamazon.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepository {

    HashMap<String, Product> map = new HashMap<>();
    public Product save(Product product) {
        String productId = String.valueOf(map.size());
        product.setId(productId);
        map.put(productId, product);
        return map.get(productId);
    }

    public Product findById(String productId) {
        if(map.containsKey(productId)) {
            return map.get(productId);
        }
        return null;
    }

    public void delete(String productId) {
        map.remove(productId);
    }

    public List<Product> searchByProductName(String name) {
        List<Product> products = new ArrayList<>();
        for (HashMap.Entry<String, Product> entry : map.entrySet()) {
            Product product = entry.getValue();
            if(product.getName().equals(name)) {
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> searchByBrand(String brand) {
        List<Product> products = new ArrayList<>();
        for (HashMap.Entry<String, Product> entry : map.entrySet()) {
            Product product = entry.getValue();
            if(product.getBrand().equals(brand)) {
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> products = new ArrayList<>();
        for (HashMap.Entry<String, Product> entry : map.entrySet()) {
            Product product = entry.getValue();
            if(product.getCategory().equals(category)) {
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        for (HashMap.Entry<String, Product> entry : map.entrySet()) {
            Product product = entry.getValue();
            products.add(product);
        }
        return products;
    }
}