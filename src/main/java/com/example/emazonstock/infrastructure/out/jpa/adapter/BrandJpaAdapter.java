package com.example.emazonstock.infrastructure.out.jpa.adapter;

import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;
import com.example.emazonstock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public void saveBrand(Brand brand) {brandRepository.save(brandEntityMapper.toEntity(brand));}

    @Override
    public Brand getBrand(String name) {
        return brandEntityMapper.toBrand(brandRepository.findByName(name).orElse(null));
    }
}
