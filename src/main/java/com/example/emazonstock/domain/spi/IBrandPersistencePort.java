package com.example.emazonstock.domain.spi;

import com.example.emazonstock.domain.model.Brand;

public interface IBrandPersistencePort {

    void saveBrand(Brand category);

    Brand getBrand(String name);
}
