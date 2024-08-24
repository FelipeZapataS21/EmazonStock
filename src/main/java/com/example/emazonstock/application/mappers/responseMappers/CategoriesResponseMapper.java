package com.example.emazonstock.application.mappers.responseMappers;

import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.domain.model.Category;

import java.util.List;

public interface CategoriesResponseMapper {

    CategoriesResponse toResponse(Category category);

    default List<CategoriesResponse> toResponseList(List<Category> categoriesList){
        return categoriesList.stream()
                .map(category -> {
                    CategoriesResponse categoriesResponse = new CategoriesResponse();
                    categoriesResponse.setName(category.getName());
                    categoriesResponse.setDescription(category.getDescription());
                    return categoriesResponse;
                }).toList();
    }
}
