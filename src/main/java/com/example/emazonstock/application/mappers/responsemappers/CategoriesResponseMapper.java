package com.example.emazonstock.application.mappers.responsemappers;

import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriesResponseMapper {

    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CategoriesResponse toResponse(Category category);

    default List<CategoriesResponse> toResponseList(List<Category> categoriesList){
        return categoriesList.stream()
                .map(category -> {
                    CategoriesResponse categoriesResponse = new CategoriesResponse();
                    categoriesResponse.setCategoryId(category.getCategoryId());
                    categoriesResponse.setName(category.getName());
                    categoriesResponse.setDescription(category.getDescription());
                    return categoriesResponse;
                }).toList();
    }
}
