package com.example.librarymanagement.controller;
import com.example.librarymanagement.model.dto.request.CategoriesRequest;
import com.example.librarymanagement.model.dto.response.CategoriesResponse;
import com.example.librarymanagement.model.entity.Categories;
import com.example.librarymanagement.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/category")
public class CategoryController {
    public final CategoryService categoryService;

    @PostMapping("/")
    public Categories createCategory(@RequestBody CategoriesRequest categoryRequest) {
        return categoryService.save(categoryRequest);
    }

    @PutMapping("/{id}")
    public Categories updateCategory(@PathVariable Long id, @RequestBody CategoriesRequest categoryRequest) {
        return categoryService.update(id, categoryRequest);
    }

    @GetMapping("/")
    public List<Categories> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriesResponse getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
