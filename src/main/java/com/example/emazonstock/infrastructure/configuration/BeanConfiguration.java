package com.example.emazonstock.infrastructure.configuration;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.api.IPageResultServicePort;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.domain.spi.IPageResultPersistencePort;
import com.example.emazonstock.domain.usecase.CategoryUseCase;
import com.example.emazonstock.domain.usecase.PageResultUseCase;
import com.example.emazonstock.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.adapter.PageResultJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;


    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IPageResultPersistencePort pageResultPersistencePort(){
        return new PageResultJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public IPageResultServicePort pageResultServicePort(){
        return new PageResultUseCase(pageResultPersistencePort());
    }
}
