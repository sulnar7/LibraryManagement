package com.example.librarymanagement.model.dto.response;

import com.example.librarymanagement.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private Long id;
    private String name;
    private String email;
    private Set<Category> categories =new HashSet<>();
}
