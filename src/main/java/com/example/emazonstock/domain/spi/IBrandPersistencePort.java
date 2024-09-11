package com.example.emazonstock.domain.spi;

import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.PageResult;

public interface IBrandPersistencePort {

    void saveBrand(Brand category);

    Brand getBrand(String name);

    PageResult<Brand> getPagedBrands(Integer page, Integer sizePage, String sort);
}
