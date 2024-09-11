package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;

import static com.example.emazonstock.domain.utils.functions.UseCaseValidationFunctions.*;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        validateIfObjectExist(categoryPersistencePort.getCategory(category.getName().trim()));
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public Category getCategory(String name) {
        Category category = categoryPersistencePort.getCategory(name);
        validateGetObject(category);
        return category;
    }

    @Override
    public PageResult<Category> getPagedCategories(Integer currentPage, Integer sizePage, String sort) {
        validateCorrectSort(sort);
        return categoryPersistencePort.getPagedCategories(currentPage, sizePage, sort);
    }

}
