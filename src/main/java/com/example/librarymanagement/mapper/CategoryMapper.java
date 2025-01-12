package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dto.request.AuthorRequest;
import com.example.librarymanagement.model.dto.request.CategoriesRequest;
import com.example.librarymanagement.model.dto.response.AuthorResponse;
import com.example.librarymanagement.model.dto.response.CategoriesResponse;
import com.example.librarymanagement.model.entity.Author;
import com.example.librarymanagement.model.entity.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Categories toCategoriesRequest(CategoriesRequest categoriesRequest);
    CategoriesResponse toCategoriesResponse(Categories categories);

    void updateCategoriesRequest(@MappingTarget Categories categories,CategoriesRequest categoriesRequest);
}
