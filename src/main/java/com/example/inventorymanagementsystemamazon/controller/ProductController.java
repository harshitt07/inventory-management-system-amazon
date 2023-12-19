package com.example.inventorymanagementsystemamazon.controller;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.events.ApiCalledEvent;
import com.example.inventorymanagementsystemamazon.exception.UnauthorizedRequestException;
import com.example.inventorymanagementsystemamazon.request.CreateProductRequest;
import com.example.inventorymanagementsystemamazon.service.ProductService;
import com.example.inventorymanagementsystemamazon.service.ValidationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ValidationService validationService;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping
    public List<Product> getAllProduct(@RequestHeader(value = "authorization", required = true) String token) throws Exception {
        if(validationService.validatedToken(token)) return productService.getAllProduct();
        throw new UnauthorizedRequestException("Request is not authenticated!");
    }

    @PostMapping
    public Product addProduct(@RequestHeader(value = "authorization", required = true) String token, @RequestBody @Valid CreateProductRequest createProductRequest) throws Exception {
        if(validationService.validatedToken(token)) {
            Product product = productService.addProduct(createProductRequest);
            eventPublisher.publishEvent(new ApiCalledEvent(this, product));
            return product;
        }
        throw new UnauthorizedRequestException("Request is not authenticated!");
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestHeader(value = "authorization", required = true) String token, @PathVariable String productId, @RequestBody CreateProductRequest createProductRequest) throws Exception {
        if(validationService.validatedToken(token)) return ResponseEntity.ok(productService.updateProduct(productId, createProductRequest));
        throw new UnauthorizedRequestException("Request is not authenticated!");
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@RequestHeader(value = "authorization", required = true) String token, @PathVariable String productId) throws Exception {
        if(validationService.validatedToken(token)) productService.deleteProduct(productId);
        throw new UnauthorizedRequestException("Request is not authenticated!");
    }

}
