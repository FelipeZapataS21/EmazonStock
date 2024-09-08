package com.example.emazonstock.domain.spi;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;

public interface IPageResultPersistencePort {

    PageResult<Category> getPagedCategories(int page, int sizePage, String sort);
}
