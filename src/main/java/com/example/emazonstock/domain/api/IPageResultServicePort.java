package com.example.emazonstock.domain.api;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;

public interface IPageResultServicePort {

    PageResult<Category> getPagedCategories(int page, int sizePage, String sort);
}
