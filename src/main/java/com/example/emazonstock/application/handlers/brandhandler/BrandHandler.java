package com.example.emazonstock.application.handlers.brandhandler;

import com.example.emazonstock.application.dto.request.BrandsRequest;
import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.BrandsResponse;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.application.mappers.requestmappers.BrandRequestMapper;
import com.example.emazonstock.application.mappers.requestmappers.PageResultRequestMapper;
import com.example.emazonstock.application.mappers.responsemappers.BrandsResponseMapper;
import com.example.emazonstock.application.mappers.responsemappers.PageResultResponseMapper;
import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.PageResult;
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

    private final PageResultResponseMapper pageResultResponseMapper;
    private final PageResultRequestMapper pageResultRequestMapper;

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

    @Override
    public PageResultResponse<Brand> createPageableResponseForBrand(PageResultRequest pageResultRequest) {
        PageResult<Brand> pageResultTransform = pageResultRequestMapper
                .toBrandPageResult(pageResultRequest);
        PageResult<Brand> pageResult = brandServicePort.getPagedBrands(
                pageResultTransform.getCurrentPage(),
                pageResultTransform.getPageSize(),
                pageResultTransform.getSort()
        );
        return pageResultResponseMapper.toBrandPageResultResponse(pageResult);
    }

}
