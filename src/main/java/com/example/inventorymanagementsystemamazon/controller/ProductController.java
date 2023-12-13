package com.example.inventorymanagementsystemamazon.controller;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.request.CreateProductRequest;
import com.example.inventorymanagementsystemamazon.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        return productService.addProduct(createProductRequest);
    }

    @PatchMapping("/{productId}")
    public void updateProduct(@PathVariable String productId, @RequestBody CreateProductRequest createProductRequest) {
        productService.updateProduct(productId, createProductRequest);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }

}
