package com.example.inventorymanagementsystemamazon.searcher;

import com.example.inventorymanagementsystemamazon.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface Searcher {
    public List<Product> search(String name);
}
