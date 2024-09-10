package com.example.emazonstock.application.handlers.categoryhandler;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.application.mappers.requestmappers.CategoriesRequestMapper;
import com.example.emazonstock.application.mappers.requestmappers.PageResultRequestMapper;
import com.example.emazonstock.application.mappers.responsemappers.CategoriesResponseMapper;
import com.example.emazonstock.application.mappers.responsemappers.PageResultResponseMapper;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{

    private final CategoriesRequestMapper categoriesRequestMapper;
    private final ICategoryServicePort categoryServicePort;
    private final CategoriesResponseMapper categoriesResponseMapper;

    private final PageResultRequestMapper pageResultRequestMapper;
    private final PageResultResponseMapper pageResultResponseMapper;


    @Override
    public void saveCategoryInCategories(CategoriesRequest categoriesRequest) {
        Category category = categoriesRequestMapper.toCategory(categoriesRequest);
        categoryServicePort.saveCategory(category);
    }


    @Override
    public CategoriesResponse getCategoryFromCategories(String categoryName) {
        Category category = categoryServicePort.getCategory(categoryName);
        return categoriesResponseMapper.toResponse(category);
    }

    @Override
    public PageResultResponse<Category> createPageableResponseForCategory(PageResultRequest pageResultRequest) {
        PageResult<Category> pageResultRequestTransform = pageResultRequestMapper
                .toCategoryPageResult(pageResultRequest);
        PageResult<Category> pageResult = categoryServicePort.getPagedCategories(
                pageResultRequestTransform.getCurrentPage(),
                pageResultRequestTransform.getPageSize(),
                pageResultRequestTransform.getSort()
        );

        return pageResultResponseMapper.toCategoryPageResultResponse(pageResult);
    }
}
