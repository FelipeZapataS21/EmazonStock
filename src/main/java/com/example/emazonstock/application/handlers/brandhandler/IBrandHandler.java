package com.example.emazonstock.application.handlers.brandhandler;

import com.example.emazonstock.application.dto.request.BrandsRequest;
import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.BrandsResponse;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.domain.model.Brand;

public interface IBrandHandler {

     void saveBrandInBrands(BrandsRequest brandsRequest);

     BrandsResponse getBrandFromBrands(String name);

     PageResultResponse<Brand> createPageableResponseForBrand(PageResultRequest pageResultRequest);
}
