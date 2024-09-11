package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;
import static com.example.emazonstock.domain.utils.functions.UseCaseValidationFunctions.*;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(Brand brand) {
        validateIfObjectExist(brandPersistencePort.getBrand(brand.getName().trim()));
        brandPersistencePort.saveBrand(brand);
    }

    @Override
    public Brand getBrand(String name) {
        Brand brand = brandPersistencePort.getBrand(name);
        validateGetObject(brand);
        return brand;
    }

    @Override
    public PageResult<Brand> getPagedBrands(Integer page, Integer sizePage, String sort) {
        validateCorrectSort(sort);
        return brandPersistencePort.getPagedBrands(page, sizePage, sort);
    }
}
