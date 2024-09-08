package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {

        if (categoryPersistencePort.getCategory(category.getName().trim()) != null) {
            throw new AlreadyDeclaredValueException();
        }

        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public Category getCategory(String name) {
        if(categoryPersistencePort.getCategory(name) == null){
            throw new ValueDoesNotExist();
        }
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public PageResult<Category> getPagedCategories(int page, int sizePage, String sort) {
        return categoryPersistencePort.getPagedCategories(page, sizePage, sort);
    }

}
