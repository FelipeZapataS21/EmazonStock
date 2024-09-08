package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.IPageResultServicePort;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.IPageResultPersistencePort;

public class PageResultUseCase implements IPageResultServicePort {

    private final IPageResultPersistencePort pageResultPersistencePort;

    public PageResultUseCase(IPageResultPersistencePort pageResultPersistencePort) {
        this.pageResultPersistencePort = pageResultPersistencePort;
    }

    @Override
    public PageResult<Category> getPagedCategories(int page, int sizePage, String sort) {
        return pageResultPersistencePort.getPagedCategories(page, sizePage, sort);
    }
}
