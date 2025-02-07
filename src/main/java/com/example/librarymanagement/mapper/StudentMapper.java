package com.example.librarymanagement.mapper;

import com.example.librarymanagement.dto.request.StudentRequest;
import com.example.librarymanagement.dto.response.StudentResponse;
import com.example.librarymanagement.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudentRequest(StudentRequest studentRequest);

    StudentResponse toStudentResponse(Student student);


    void updateStudent(@MappingTarget Student student, StudentRequest request);
}
