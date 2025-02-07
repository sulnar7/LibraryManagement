package com.example.librarymanagement.service;

import com.example.librarymanagement.exception.errors.AuthorNotFoundException;
import com.example.librarymanagement.mapper.AuthorMapper;
import com.example.librarymanagement.dto.request.AuthorRequest;
import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.librarymanagement.util.StaticVariables.AUTHOR_NOT_FOUND_MESSAGE;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public Author save(AuthorRequest authorRequest) {
        log.info("Author saved : {} saved", authorRequest.toString());

        Author author = authorMapper.toAuthorRequest(authorRequest);

        Set<Book> books = new HashSet<>(bookRepository.findAllById(authorRequest.getBookIds()));
        author.setBooks(books);
        log.info("Author saved 1: {} saved", author);

        return authorRepository.save(author);

    }


    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }


    public List<Author> findAll() {
        return authorRepository.findAll();
    }


    public void delete(Long id) {
        authorRepository.deleteById(id);
    }


    public Author update(Long id, AuthorRequest authorRequest) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new AuthorNotFoundException(AUTHOR_NOT_FOUND_MESSAGE));
        authorMapper.updateAuthor(author, authorRequest);
        return authorRepository.save(author);
    }

}
