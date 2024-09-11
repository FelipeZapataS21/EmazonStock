package com.example.emazonstock.application.handlers.brandhandler;

import com.example.emazonstock.application.dto.request.BrandsRequest;
import com.example.emazonstock.application.dto.response.BrandsResponse;

public interface IBrandHandler {

     void saveBrandInBrands(BrandsRequest brandsRequest);

     BrandsResponse getBrandFromBrands(String name);
}
