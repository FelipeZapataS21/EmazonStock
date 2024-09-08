package com.example.emazonstock.domain.api;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;

public interface ICategoryServicePort {

    void saveCategory(Category category);

    Category getCategory(String name);

    PageResult<Category> getPagedCategories(int page, int sizePage, String sort);

}
