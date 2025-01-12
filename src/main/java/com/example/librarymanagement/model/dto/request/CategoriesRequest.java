package com.example.librarymanagement.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriesRequest {
    private Long id;
    private String name;
}
