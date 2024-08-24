package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.DescriptionRequiredException;
import com.example.emazonstock.domain.exceptions.MaximumLengthException;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;

import java.util.List;

import static com.example.emazonstock.domain.utils.DomainConstants.*;


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

        if(categoryPersistencePort.getCategory(category.getName()) != null){
            throw new AlreadyDeclaredValueException("This Category " + FIELD_ALREADY_DECLARED_VALUE);
        }
        if(category.getName().length() > 50){throw new MaximumLengthException("Name " + FIELD_MAX_LENGTH);}

        if(category.getDescription().trim().isEmpty()){
            throw new DescriptionRequiredException("Description " + FIELD_VALUE_REQUIRED);
        }
        if(category.getDescription().length() > 90){
            throw new MaximumLengthException("Description " + FIELD_MAX_LENGTH);
        }

        categoryPersistencePort.saveCategory(category);
    }
}
