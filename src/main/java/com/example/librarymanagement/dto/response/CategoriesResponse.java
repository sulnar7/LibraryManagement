package com.example.librarymanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriesResponse {
    private Long id;
    private String name;
}
