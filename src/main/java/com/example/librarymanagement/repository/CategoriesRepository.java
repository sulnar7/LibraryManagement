package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
}
