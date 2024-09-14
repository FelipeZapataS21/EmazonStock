package com.example.emazonstock.infrastructure.out.jpa.adapter;

import com.example.emazonstock.domain.model.Article;
import com.example.emazonstock.domain.spi.IArticlePersistencePort;
import com.example.emazonstock.infrastructure.out.jpa.mapper.ArticleEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.IArticleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleJpaAdapter implements IArticlePersistencePort {

    private final IArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(articleEntityMapper.toEntity(article));
    }
}
