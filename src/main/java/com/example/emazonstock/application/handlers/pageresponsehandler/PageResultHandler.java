package com.example.emazonstock.application.handlers.pageresponsehandler;

import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.application.mappers.requestmappers.PageResultRequestMapper;
import com.example.emazonstock.application.mappers.responsemappers.PageResultResponseMapper;
import com.example.emazonstock.domain.api.IPageResultServicePort;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PageResultHandler implements IPageResultHandler {

    private final IPageResultServicePort pageResultServicePort;
    private final PageResultRequestMapper pageResultRequestMapper;
    private final PageResultResponseMapper pageResultResponseMapper;

    @Override
    public PageResultResponse<Category> createPageableResponseForCategory(PageResultRequest pageResultRequest) {
        PageResult<Category> pageResultRequestTransform = pageResultRequestMapper.toCategoryPageResult(pageResultRequest);
        PageResult<Category> pageResult = pageResultServicePort.getPagedCategories(
                pageResultRequestTransform.getCurrentPage(),
                pageResultRequestTransform.getPageSize(),
                pageResultRequestTransform.getSort()
        );

        return pageResultResponseMapper.toCategoryPageResultResponse(pageResult);
    }
}
