package com.example.librarymanagement.service;

import com.example.librarymanagement.mapper.BookMapper;
import com.example.librarymanagement.model.dto.request.BookRequest;
import com.example.librarymanagement.model.entity.Book;
import com.example.librarymanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;


    public Book save(BookRequest book) {
        Book bookSaved = bookMapper.toBookRequest(book);
        log.info("Book saved : {}", bookSaved.toString());

        //I will add Amazon S3 for image
        return bookRepository.save(bookSaved);

    }

    public Book findById(Long id) {
        log.info("Find Book by id : {}", id);
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void delete(Long id) {
        log.info("Delete Book by id : {}", id);
        bookRepository.deleteById(id);
    }

    public Book update(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElse(null);
        bookMapper.updateBook(book, bookRequest);
        return bookRepository.save(book);
    }
}
