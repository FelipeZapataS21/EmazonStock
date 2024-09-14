package com.example.emazonstock.infrastructure.configuration;

import com.example.emazonstock.domain.api.IArticleServicePort;
import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.spi.IArticlePersistencePort;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.domain.usecase.ArticleUseCase;
import com.example.emazonstock.domain.usecase.BrandUseCase;
import com.example.emazonstock.domain.usecase.CategoryUseCase;
import com.example.emazonstock.infrastructure.out.jpa.adapter.ArticleJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.adapter.BrandJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.example.emazonstock.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.mapper.BrandEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.IArticleRepository;
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

    private final IArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

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

    @Bean
    public IArticlePersistencePort articlePersistencePort(){
        return new ArticleJpaAdapter(articleRepository, articleEntityMapper);
    }

    @Bean
    public IArticleServicePort articleServicePort(){return new ArticleUseCase(articlePersistencePort());}
}
