package com.example.librarymanagement.service;

import com.example.librarymanagement.exception.errors.AuthorNotFoundException;
import com.example.librarymanagement.mapper.AuthorMapper;
import com.example.librarymanagement.dto.request.AuthorRequest;
import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.librarymanagement.util.StaticVariables.AUTHOR_NOT_FOUND_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorMapper authorMapper;

    @InjectMocks
    private AuthorService authorService;

    private Author author;
    private AuthorRequest authorRequest;

    @BeforeEach
    void setUp() {
        author = new Author(1L, "John Doe", "john@example.com", Set.of());
        authorRequest = new AuthorRequest("John Doe", "john@example.com", Set.of(1L));
    }

    @Test
    void testSaveAuthor() {
        // Arrange
        when(authorMapper.toAuthorRequest(authorRequest)).thenReturn(author);
        when(bookRepository.findAllById(authorRequest.getBookIds())).thenReturn(List.of());
        when(authorRepository.save(author)).thenReturn(author);

        // Act
        Author savedAuthor = authorService.save(authorRequest);

        // Assert
        assertNotNull(savedAuthor);
        assertEquals(author.getName(), savedAuthor.getName());
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    void testFindById_AuthorExists() {
        // Arrange
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        // Act
        Author foundAuthor = authorService.findById(1L);

        // Assert
        assertNotNull(foundAuthor);
        assertEquals(1L, foundAuthor.getId());
        verify(authorRepository, times(1)).findById(1L);
    }

    @Test
    void testFindById_AuthorNotFound() {
        // Arrange
        when(authorRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Author foundAuthor = authorService.findById(1L);

        // Assert
        assertNull(foundAuthor);
        verify(authorRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAllAuthors() {
        // Arrange
        when(authorRepository.findAll()).thenReturn(List.of(author));

        // Act
        List<Author> authors = authorService.findAll();

        // Assert
        assertFalse(authors.isEmpty());
        assertEquals(1, authors.size());
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    void testDeleteAuthor() {
        // Act
        authorService.delete(1L);

        // Assert
        verify(authorRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateAuthor_Success() {
        // Arrange
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));
        doNothing().when(authorMapper).updateAuthor(author, authorRequest);
        when(authorRepository.save(author)).thenReturn(author);

        // Act
        Author updatedAuthor = authorService.update(1L, authorRequest);

        // Assert
        assertNotNull(updatedAuthor);
        verify(authorRepository, times(1)).save(author);
    }

    @Test
    void testUpdateAuthor_NotFound() {
        // Arrange
        when(authorRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        AuthorNotFoundException exception = assertThrows(
                AuthorNotFoundException.class,
                () -> authorService.update(1L, authorRequest)
        );

        assertEquals(AUTHOR_NOT_FOUND_MESSAGE, exception.getMessage());
        verify(authorRepository, times(1)).findById(1L);
    }
}