package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.dto.request.BookRequest;
import com.example.librarymanagement.model.entity.Book;
import com.example.librarymanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/books")
public class BookController {
    public final BookService bookService;

    @PostMapping("/")
    public Book createBook(@RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        return bookService.update(id, bookRequest);
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getbooksBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.delete(id);
    }
}
