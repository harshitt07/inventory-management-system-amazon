package com.example.inventorymanagementsystemamazon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    String id;
    String name;
    Integer price;
    String brand;
    String category;
    Integer quantity;
}
