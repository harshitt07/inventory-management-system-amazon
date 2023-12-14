package com.example.inventorymanagementsystemamazon.searcher;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryBasedSearcher implements Searcher {

    private final ProductRepository productRepository;

    @Override
    public List<Product> search(String category) {
        return productRepository.searchByCategory(category);
    }
}
