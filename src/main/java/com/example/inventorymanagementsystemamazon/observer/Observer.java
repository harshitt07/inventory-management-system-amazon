package com.example.inventorymanagementsystemamazon.observer;

import com.example.inventorymanagementsystemamazon.entity.Product;

public interface Observer {
    public void update(Product product);
}
