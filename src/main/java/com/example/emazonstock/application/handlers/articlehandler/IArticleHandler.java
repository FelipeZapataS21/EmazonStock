package com.example.emazonstock.application.handlers.articlehandler;

import com.example.emazonstock.application.dto.request.article.StringArticleRequest;

public interface IArticleHandler{

    void saveArticleInArticles(StringArticleRequest stringArticleRequest);

}
