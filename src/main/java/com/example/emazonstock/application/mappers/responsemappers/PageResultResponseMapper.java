package com.example.emazonstock.application.mappers.responsemappers;

import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PageResultResponseMapper {

    @Mapping(source = "data", target = "data")
    @Mapping(source = "currentPage", target = "currentPage")
    @Mapping(source = "totalPages", target = "totalPages")
    @Mapping(source = "totalItems", target = "totalItems")
    @Mapping(source = "pageSize", target = "pageSize")
    @Mapping(source = "sort", target = "sort")
    PageResultResponse<Category> toCategoryPageResultResponse(PageResult<Category> pageResult);

    @Mapping(source = "data", target = "data")
    @Mapping(source = "currentPage", target = "currentPage")
    @Mapping(source = "totalPages", target = "totalPages")
    @Mapping(source = "totalItems", target = "totalItems")
    @Mapping(source = "pageSize", target = "pageSize")
    @Mapping(source = "sort", target = "sort")
    PageResultResponse<Brand> toBrandPageResultResponse(PageResult<Brand> pageResult);
}
