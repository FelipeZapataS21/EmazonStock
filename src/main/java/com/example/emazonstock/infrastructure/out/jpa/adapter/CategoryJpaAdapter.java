package com.example.emazonstock.infrastructure.out.jpa.adapter;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.infrastructure.exception.CategoryAlreadyExist;
import com.example.emazonstock.infrastructure.exception.CategoryNotFound;
import com.example.emazonstock.infrastructure.exception.NoDataFoundException;
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
        if(categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExist();
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        if(categoryEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public Category getCategory(String name) {
        return categoryEntityMapper.toCategory(categoryRepository.findByName(name).
                orElseThrow(CategoryNotFound::new));
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public void deleteCategory(String name) {
        categoryRepository.deleteByName(name);
    }
}
