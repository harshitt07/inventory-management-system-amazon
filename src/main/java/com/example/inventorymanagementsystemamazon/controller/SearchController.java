package com.example.inventorymanagementsystemamazon.controller;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.searcher.NameBasedSearcher;
import com.example.inventorymanagementsystemamazon.searcher.Searcher;
import com.example.inventorymanagementsystemamazon.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/productName/{productName}")
    public List<Product> searchByName(@PathVariable String productName) {
        return searchService.search();
    }

    @GetMapping("/category")
    public List<Product> searchByCategory(@PathVariable String category) {
        return null;
    }

    @GetMapping("/brand")
    public List<Product> searchByBrand(@PathVariable String brand) {
        return null;
    }

}
