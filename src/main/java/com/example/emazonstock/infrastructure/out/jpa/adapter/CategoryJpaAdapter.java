package com.example.emazonstock.infrastructure.out.jpa.adapter;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.emazonstock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort{

    private final ICategoryRepository categoryRepository;

    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return categoryEntityMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public Category getCategory(String name) {
        return categoryEntityMapper.toCategory(categoryRepository.findByName(name).
                orElse(null));
    }
}
