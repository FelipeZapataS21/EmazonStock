package com.example.emazonstock.application.mappers.requestmappers;

import com.example.emazonstock.application.dto.request.BrandsRequest;
import com.example.emazonstock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandRequestMapper {

    @Mapping(target = "brandId", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(target = "articles", ignore = true)
    Brand toBrand(BrandsRequest brandsRequest);
}
