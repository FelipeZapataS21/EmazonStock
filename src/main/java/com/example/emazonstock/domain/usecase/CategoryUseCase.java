package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.exceptions.*;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;

import java.util.Arrays;
import java.util.List;

import static com.example.emazonstock.domain.utils.ExceptionsConstants.*;
import static com.example.emazonstock.domain.utils.UseCaseCategoryConstants.*;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        if (categoryPersistencePort.getCategory(category.getName().trim()) != null) {
            throw new AlreadyDeclaredValueException(EXCEPTION_VALUE_ALREADY_EXIST);
        }
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public Category getCategory(String name) {
        if(categoryPersistencePort.getCategory(name) == null){
            throw new ValueDoesNotExist(EXCEPTION_NO_VALUE_FOUND);
        }
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public PageResult<Category> getPagedCategories(Integer currentPage, Integer sizePage, String sort) {
        List<String> validSortValues = Arrays.asList(VALUE_PAGE_SORT_ASC,VALUE_PAGE_SORT_DESC);
        if (!validSortValues.contains(sort.toLowerCase()) ) {
            throw new NotValidValuePageSort(EXCEPTION_NOT_VALID_VALUE_PAGE_SORT);
        }
        return categoryPersistencePort.getPagedCategories(currentPage, sizePage, sort);
    }

}
