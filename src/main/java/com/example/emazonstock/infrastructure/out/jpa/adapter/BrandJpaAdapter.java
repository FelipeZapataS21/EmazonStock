package com.example.emazonstock.infrastructure.out.jpa.adapter;

import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;
import com.example.emazonstock.infrastructure.out.jpa.entity.BrandEntity;
import com.example.emazonstock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Override
    public PageResult<Brand> getPagedBrands(Integer currentPage, Integer sizePage, String orderSort) {
        Sort sort = Sort.by(Sort.Direction.fromString(orderSort), "name");
        Pageable pageable = PageRequest.of(currentPage, sizePage, sort);
        Page<BrandEntity> brandEntityPage = brandRepository.findAll(pageable);
        List<Brand> brandList = brandEntityMapper.toBrandList(brandEntityPage.getContent());

        return new PageResult<>(
                brandList,
                brandEntityPage.getNumber(),
                brandEntityPage.getTotalPages(),
                brandEntityPage.getTotalElements(),
                brandEntityPage.getSize(),
                sort.toString()
        );
    }
}
