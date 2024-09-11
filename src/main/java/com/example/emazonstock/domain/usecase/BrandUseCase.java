package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(Brand category) {
    }

    @Override
    public Brand getBrand(String name) {
        return null;
    }
}
