package com.example.emazonstock.domain.api;

import com.example.emazonstock.domain.model.Brand;

public interface IBrandServicePort {

    void saveBrand(Brand brand);

    Brand getBrand(String name);
}
