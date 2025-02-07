package com.example.librarymanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    private String name;
    private String email;
    private Set<Long> bookIds = new HashSet<>();

}
