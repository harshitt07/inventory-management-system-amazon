package com.example.inventorymanagementsystemamazon.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.example.inventorymanagementsystemamazon.entity.Product;

@Getter
public class ApiCalledEvent extends ApplicationEvent {

    private final String message;

    public ApiCalledEvent(Object source, Product product) {
        super(source);
        this.message = product.getQuantity() + " quantity of product " + product.getName() + " has been added.";
    }

}