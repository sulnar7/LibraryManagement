package com.example.librarymanagement.service;

import com.example.librarymanagement.mapper.BookMapper;
import com.example.librarymanagement.dto.request.BookRequest;
import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Category;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoriesRepository categoriesRepository;

    public Book save(BookRequest bookRequest) {
//        Book bookSaved = bookMapper.toBookRequest(book);
//        log.info("Book saved : {}", bookSaved.toString());
////        book.setAuthor(book.getAuthor());
////        book.setName(book.getName());
////        book.setCategories(book.getCategories());
////        book.setImageUrl(book.getImageUrl());
//        //I will add Amazon S3 for image
//        return bookRepository.save(bookSaved);

        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setImageUrl(bookRequest.getImageUrl());
        log.info("Book to string", bookRequest.getCategoryId(), bookRequest.getName());

        // Müəllifləri ID-lərə əsasən tapırıq
        Set<Author> authors = new HashSet<>(authorRepository.findAllById(bookRequest.getAuthorIds()));
        book.setAuthor(authors);

        // Kateqoriyanı ID-yə əsasən tapırıq
        Category category = categoriesRepository.findById(bookRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        book.setCategory(category);

        return bookRepository.save(book);

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
