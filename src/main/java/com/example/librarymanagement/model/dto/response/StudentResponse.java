package com.example.librarymanagement.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private int sID;
}