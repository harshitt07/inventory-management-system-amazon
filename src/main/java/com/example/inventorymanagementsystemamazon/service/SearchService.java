package com.example.inventorymanagementsystemamazon.service;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.searcher.Searcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final Searcher searcher;

    public List<Product> search() {
        return null;
    }
}
