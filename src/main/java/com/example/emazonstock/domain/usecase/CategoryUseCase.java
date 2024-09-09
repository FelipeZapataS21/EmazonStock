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
    public PageResult<Category> getPagedCategories(Integer currentPage, Integer sizePage, String sort) {
        return categoryPersistencePort.getPagedCategories(currentPage, sizePage, sort);
    }

    // Que pasa si uno de los valores es null o esta en blanco?
    // Que pasa si esta mal escrito?
    // Que pasa si es un numero lo que se envia en el sort
    // Que pasa si el valor de la lista es vacio?

}
