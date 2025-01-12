package com.example.librarymanagement.service;

import com.example.librarymanagement.mapper.AuthorMapper;
import com.example.librarymanagement.model.dto.request.AuthorRequest;
import com.example.librarymanagement.model.entity.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;
    public Author save(AuthorRequest author) {
        Author authorSaved = authorMapper.toAuthorRequest(author);
        log.info("Author saved : {}", authorSaved.toString());

        return authorRepository.save(authorSaved);

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
        Author author = authorRepository.findById(id).orElse(null);
        authorMapper.updateAuthor(author, authorRequest);
        return authorRepository.save(author);
    }
}
