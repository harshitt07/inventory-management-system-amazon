package com.example.inventorymanagementsystemamazon.controller;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.events.ApiCalledEvent;
import com.example.inventorymanagementsystemamazon.request.CreateProductRequest;
import com.example.inventorymanagementsystemamazon.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping
    public List<Product> getAllProduct() throws Exception {
        return productService.getAllProduct();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid CreateProductRequest createProductRequest) throws Exception {
        Product product = productService.addProduct(createProductRequest);
        eventPublisher.publishEvent(new ApiCalledEvent(this, product));
        return ResponseEntity.ok().body(product);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody CreateProductRequest createProductRequest) throws Exception {
        return ResponseEntity.ok(productService.updateProduct(productId, createProductRequest));
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable String productId) throws Exception {
        productService.deleteProduct(productId);
    }

}
