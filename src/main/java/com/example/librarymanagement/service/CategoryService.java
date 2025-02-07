package com.example.librarymanagement.service;

import com.example.librarymanagement.mapper.CategoryMapper;
import com.example.librarymanagement.dto.request.CategoriesRequest;
import com.example.librarymanagement.dto.response.CategoriesResponse;
import com.example.librarymanagement.entity.Category;
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

    public Category save(CategoriesRequest categories) {
        Category categorySaved = categoryMapper.toCategoriesRequest(categories);
        log.info("Categories saved : {}", categorySaved.toString());

        return categoriesRepository.save(categorySaved);

    }

    public CategoriesResponse findById(Long id) {
        log.info("Find Category by id : {}", id);
        Category category = categoriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        CategoriesResponse categoriesResponse = categoryMapper.toCategoriesResponse(category);

        return categoriesResponse;
    }

    public List<Category> findAll() {
        log.info("Find all Categories ");
        return categoriesRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Delete Category by id : {}", id);

        categoriesRepository.deleteById(id);
    }

    public Category update(Long id, CategoriesRequest categoriesRequest) {
        Category category = categoriesRepository.findById(id).orElse(null);
        categoryMapper.updateCategoriesRequest(category, categoriesRequest);
        log.info("Update Category by id : {}", id);
        return categoriesRepository.save(category);
    }


}
