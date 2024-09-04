package com.example.emazonstock.domain.spi;

import com.example.emazonstock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {

    void saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategory(String name);

}
