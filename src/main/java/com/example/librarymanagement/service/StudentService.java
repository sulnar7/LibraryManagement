package com.example.librarymanagement.service;

import com.example.librarymanagement.mapper.StudentMapper;
import com.example.librarymanagement.dto.request.StudentRequest;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public Student save(StudentRequest student) {
        Student studentSaved = studentMapper.toStudentRequest(student);
        log.info("Student saved : {}", studentSaved.toString());


        return studentRepository.save(studentSaved);

    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findAll() {
        log.info("Find all students");
        return studentRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Delete student : {}", id);
        studentRepository.deleteById(id);
    }

    public Student update(Long id, StudentRequest studentRequest) {

        Student student = studentRepository.findById(id).orElse(null);
        studentMapper.updateStudent(student, studentRequest);
        log.info("Student updated : {}", student.toString());
        return studentRepository.save(student);
    }
}
