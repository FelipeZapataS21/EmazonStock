package com.example.emazonstock.domain.api;

import com.example.emazonstock.domain.model.Article;

public interface IArticleServicePort {

    void saveArticle(Article article);
}
