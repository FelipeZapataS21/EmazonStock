package com.example.emazonstock.application.handlers.categoryhandler;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.application.mappers.requestmappers.CategoriesRequestMapper;
import com.example.emazonstock.application.mappers.responsemappers.CategoriesResponseMapper;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{

        private final CategoriesRequestMapper categoriesRequestMapper;
        private final ICategoryServicePort categoryServicePort;
        private final CategoriesResponseMapper categoriesResponseMapper;


    @Override
    public void saveCategoryInCategories(CategoriesRequest categoriesRequest) {
        Category category = categoriesRequestMapper.toCategory(categoriesRequest);
        categoryServicePort.saveCategory(category);
    }

    @Override
    public List<CategoriesResponse> getAllCategoriesFromCategories() {
        return categoriesResponseMapper.toResponseList(categoryServicePort.getAllCategories());
    }

    @Override
    public CategoriesResponse getCategoryFromCategories(String categoryName) {
        Category category = categoryServicePort.getCategory(categoryName);
        return categoriesResponseMapper.toResponse(category);
    }

    @Override
    public void updateCategoryFromCategories(CategoriesRequest categoriesRequest) {
        Category oldCategory = categoryServicePort.getCategory(categoriesRequest.getName());
        Category newCategory = categoriesRequestMapper.toCategory(categoriesRequest);
        newCategory.setCategoryId(oldCategory.getCategoryId());
        categoryServicePort.updateCategory(newCategory);
    }

    @Override
    public void deleteCategoryFromCategories(String name) {
        categoryServicePort.deleteCategory(name);
    }
}
