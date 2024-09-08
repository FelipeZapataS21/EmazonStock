package com.example.emazonstock.application.handlers.pageresponsehandler;

import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.domain.model.Category;

public interface IPageResultHandler {

    PageResultResponse<Category> createPageableResponseForCategory(PageResultRequest pageResultRequest);
}
