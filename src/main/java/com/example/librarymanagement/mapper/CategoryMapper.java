package com.example.librarymanagement.mapper;

import com.example.librarymanagement.model.dto.request.CategoriesRequest;
import com.example.librarymanagement.model.dto.response.CategoriesResponse;
import com.example.librarymanagement.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategoriesRequest(CategoriesRequest categoriesRequest);
    CategoriesResponse toCategoriesResponse(Category category);

    void updateCategoriesRequest(@MappingTarget Category category, CategoriesRequest categoriesRequest);
}
