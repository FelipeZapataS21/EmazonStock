package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;

import java.util.List;

import static com.example.emazonstock.domain.utils.ValidationFunctions.*;


public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryPersistencePort.getAllCategories();
    }

    @Override
    public Category getCategory(String name) {
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public void updateCategory(Category category) {
        categoryPersistencePort.updateCategory(category);
    }

    @Override
    public void deleteCategory(String name) {
        categoryPersistencePort.deleteCategory(name);
    }

    @Override
    public void saveCategory(Category category) {

        alreadyDeclaredValueValidation(categoryPersistencePort.getCategory(category.getName()).getName());

        categoryPersistencePort.saveCategory(category);
    }
}
