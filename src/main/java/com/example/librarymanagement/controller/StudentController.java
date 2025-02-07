package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.request.StudentRequest;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/students")
public class StudentController {
    public final StudentService studentService;

    @PostMapping("/")
    public Student createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.update(id, studentRequest);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.delete(id);
    }
}
