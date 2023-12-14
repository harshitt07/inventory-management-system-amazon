package com.example.inventorymanagementsystemamazon.service;

import com.example.inventorymanagementsystemamazon.entity.Product;
import com.example.inventorymanagementsystemamazon.entity.SearchCriteria;
import com.example.inventorymanagementsystemamazon.searcher.BrandBasedSearcher;
import com.example.inventorymanagementsystemamazon.searcher.CategoryBasedSearcher;
import com.example.inventorymanagementsystemamazon.searcher.NameBasedSearcher;
import com.example.inventorymanagementsystemamazon.searcher.Searcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final NameBasedSearcher nameBasedSearcher;
    private final CategoryBasedSearcher categoryBasedSearcher;
    private final BrandBasedSearcher brandBasedSearcher;

    public List<Product> search(String filter, SearchCriteria searchCriteria) {
        if(searchCriteria.equals(SearchCriteria.NAME)) return nameBasedSearcher.search(filter);
        if(searchCriteria.equals(SearchCriteria.CATEGORY)) return categoryBasedSearcher.search(filter);
        if(searchCriteria.equals(SearchCriteria.BRAND)) return brandBasedSearcher.search(filter);
        return null;
    }
}
