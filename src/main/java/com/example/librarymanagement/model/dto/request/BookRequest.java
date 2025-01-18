package com.example.librarymanagement.model.dto.request;

import com.example.librarymanagement.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String imageUrl;
    private Set<Category> categories = new HashSet<>();
}
