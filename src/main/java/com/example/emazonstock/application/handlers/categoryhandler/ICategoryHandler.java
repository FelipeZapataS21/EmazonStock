package com.example.emazonstock.application.handlers.categoryhandler;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.dto.response.CategoriesResponse;

import java.util.List;

public interface ICategoryHandler {

    void saveCategoryInCategories(CategoriesRequest categoriesRequest);

    List<CategoriesResponse> getAllCategoriesFromCategories();

    CategoriesResponse getCategoryFromCategories(String name);

    void updateCategoryFromCategories(CategoriesRequest categoriesRequest);

    void deleteCategoryFromCategories(String name);
}
