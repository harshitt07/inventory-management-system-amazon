package com.example.inventorymanagementsystemamazon.observer;

import com.example.inventorymanagementsystemamazon.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductObserver implements Observer {

    @Override
    public void update(Product product) {
        log.info("New Product {} with Quantity {} is added!", product.getName(), product.getQuantity());
    }
}
