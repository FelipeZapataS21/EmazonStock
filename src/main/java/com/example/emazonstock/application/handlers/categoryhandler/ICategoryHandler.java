package com.example.emazonstock.application.handlers.categoryhandler;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.domain.model.Category;

public interface ICategoryHandler {

    void saveCategoryInCategories(CategoriesRequest categoriesRequest);

    CategoriesResponse getCategoryFromCategories(String name);

    PageResultResponse<Category> createPageableResponseForCategory(PageResultRequest pageResultRequest);
}
