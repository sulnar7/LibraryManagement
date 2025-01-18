package com.example.librarymanagement.model.dto.request;

import com.example.librarymanagement.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class StudentRequest {

    private String name;
    private String email;
    private int sID;
}
