package com.example.emazonstock.application.mappers.responsemappers;

import com.example.emazonstock.application.dto.response.BrandsResponse;
import com.example.emazonstock.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandsResponseMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    BrandsResponse toResponse(Brand brand);

    default List<BrandsResponse> toResponseList(List<Brand> brandsList){
        return brandsList.stream()
                .map(category -> {
                    BrandsResponse brandsResponse = new BrandsResponse();
                    brandsResponse.setName(category.getName());
                    brandsResponse.setDescription(category.getDescription());
                    return brandsResponse;
                }).toList();
    }
}
