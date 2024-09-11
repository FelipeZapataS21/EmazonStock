package com.example.emazonstock.application.mappers.requestmappers;

import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PageResultRequestMapper {

    @Mapping(source = "currentPage", target = "currentPage")
    @Mapping(source = "pageSize", target = "pageSize")
    @Mapping(source = "sort", target = "sort")
    PageResult<Category> toCategoryPageResult(PageResultRequest pageResultRequest);

    @Mapping(source = "currentPage", target = "currentPage")
    @Mapping(source = "pageSize", target = "pageSize")
    @Mapping(source = "sort", target = "sort")
    PageResult<Brand> toBrandPageResult(PageResultRequest pageResultRequest);
}
