package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.dto.request.AuthorRequest;
import com.example.librarymanagement.model.entity.Author;
import com.example.librarymanagement.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/authors")
public class AuthorsController {
    public final AuthorService authorService;
    @PostMapping("/")
    public Author createAuthor(@RequestBody AuthorRequest authorRequest) {
        return authorService.save(authorRequest);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest) {
        return authorService.update(id,authorRequest);
    }

    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Long id) {
        authorService.delete(id);
    }
}
