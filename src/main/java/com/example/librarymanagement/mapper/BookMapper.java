package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dto.request.BookRequest;
import com.example.librarymanagement.model.dto.response.BookResponse;
import com.example.librarymanagement.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBookRequest(BookRequest bookRequest);

    BookResponse toBookResponse(Book book);


    void updateBook(@MappingTarget Book book, BookRequest request);
}
