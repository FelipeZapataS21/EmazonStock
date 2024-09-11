package com.example.emazonstock.domain.api;

import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.PageResult;

public interface IBrandServicePort {

    void saveBrand(Brand brand);

    Brand getBrand(String name);

    PageResult<Brand> getPagedBrands(Integer page, Integer sizePage, String sort);
}
