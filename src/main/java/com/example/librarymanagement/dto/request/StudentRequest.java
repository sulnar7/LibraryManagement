package com.example.librarymanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentRequest {

    private String name;
    private String email;
    private int sID;
}
