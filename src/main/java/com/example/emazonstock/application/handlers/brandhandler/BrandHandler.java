package com.example.emazonstock.application.handlers.brandhandler;

import com.example.emazonstock.application.dto.request.BrandsRequest;
import com.example.emazonstock.application.dto.response.BrandsResponse;
import com.example.emazonstock.application.mappers.requestmappers.BrandRequestMapper;
import com.example.emazonstock.application.mappers.responsemappers.BrandsResponseMapper;
import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandHandler implements IBrandHandler{

    private final BrandRequestMapper brandRequestMapper;
    private final IBrandServicePort brandServicePort;
    private final BrandsResponseMapper brandsResponseMapper;

    @Override
    public void saveBrandInBrands(BrandsRequest brandsRequest) {
        Brand brand = brandRequestMapper.toBrand(brandsRequest);
        brandServicePort.saveBrand(brand);
    }

    @Override
    public BrandsResponse getBrandFromBrands(String name) {
        Brand brand = brandServicePort.getBrand(name);
        return brandsResponseMapper.toResponse(brand);
    }

}
