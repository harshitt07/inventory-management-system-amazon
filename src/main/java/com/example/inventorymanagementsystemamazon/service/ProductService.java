package com.example.inventorymanagementsystemamazon.service;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.repository.ProductRepository;
import com.example.inventorymanagementsystemamazon.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Product addProduct(CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .name(createProductRequest.getName())
                .category(createProductRequest.getCategory())
                .price(createProductRequest.getPrice())
                .quantity(createProductRequest.getPrice())
                .brand(createProductRequest.getBrand())
                .build();
        return productRepository.save(product);
    }

    public void updateProduct(String productId, CreateProductRequest createProductRequest) {
        Product product = productRepository.findById(productId);
    }
    public void deleteProduct(String productId) {
        productRepository.delete(productId);
    }

}
