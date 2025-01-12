package com.example.librarymanagement.service;

import com.example.librarymanagement.mapper.CategoryMapper;
import com.example.librarymanagement.model.dto.request.CategoriesRequest;
import com.example.librarymanagement.model.dto.response.CategoriesResponse;
import com.example.librarymanagement.model.entity.Categories;
import com.example.librarymanagement.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoriesRepository categoriesRepository;

    public Categories save(CategoriesRequest categories) {
        Categories categoriesSaved = categoryMapper.toCategoriesRequest(categories);
        log.info("Categories saved : {}", categoriesSaved.toString());

        return categoriesRepository.save(categoriesSaved);

    }

    public CategoriesResponse findById(Long id) {
        log.info("Find Category by id : {}", id);
        Categories categories = categoriesRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        CategoriesResponse categoriesResponse=categoryMapper.toCategoriesResponse(categories);

        return categoriesResponse;
    }

    public List<Categories> findAll() {
        log.info("Find all Categories ");
        return categoriesRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Delete Category by id : {}", id);

        categoriesRepository.deleteById(id);
    }

    public Categories update(Long id, CategoriesRequest categoriesRequest) {
        Categories categories = categoriesRepository.findById(id).orElse(null);
        categoryMapper.updateCategoriesRequest(categories,categoriesRequest);
        log.info("Update Category by id : {}", id);
        return categoriesRepository.save(categories);
    }
}
