package com.example.emazonstock.infrastructure.configuration;

import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.domain.usecase.BrandUseCase;
import com.example.emazonstock.domain.usecase.CategoryUseCase;
import com.example.emazonstock.infrastructure.out.jpa.adapter.BrandJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.IBrandRepository;
import com.example.emazonstock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    private final IBrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IBrandPersistencePort brandPersistencePort(){
        return new BrandJpaAdapter(brandRepository, brandEntityMapper);
    }

    @Bean
    public IBrandServicePort brandServicePort(){return new BrandUseCase(brandPersistencePort());}
}
