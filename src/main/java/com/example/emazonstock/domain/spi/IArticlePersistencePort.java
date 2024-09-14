package com.example.emazonstock.domain.spi;

import com.example.emazonstock.domain.model.Article;

public interface IArticlePersistencePort {

    void saveArticle(Article article);
}
