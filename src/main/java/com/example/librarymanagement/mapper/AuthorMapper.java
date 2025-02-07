package com.example.librarymanagement.mapper;

import com.example.librarymanagement.dto.request.AuthorRequest;
import com.example.librarymanagement.dto.response.AuthorResponse;
import com.example.librarymanagement.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthorRequest(AuthorRequest authorRequest);

    AuthorResponse toAuthorResponse(Author author);


    void updateAuthor(@MappingTarget Author author, AuthorRequest request);
}
