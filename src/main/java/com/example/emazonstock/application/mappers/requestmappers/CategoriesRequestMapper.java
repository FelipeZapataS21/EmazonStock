package com.example.emazonstock.application.mappers.requestmappers;


import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoriesRequestMapper {

    @Mapping(target = "categoryId", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(target = "articles", ignore = true)
    Category toCategory(CategoriesRequest categoriesRequest);
}
