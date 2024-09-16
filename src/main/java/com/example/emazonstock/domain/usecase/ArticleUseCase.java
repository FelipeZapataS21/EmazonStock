package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.api.IArticleServicePort;
import com.example.emazonstock.domain.model.Article;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.IArticlePersistencePort;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.emazonstock.domain.utils.constants.ArticleUseCaseConstants.LIMIT_OF_CATEGORIES_IN_ARTICLE;
import static com.example.emazonstock.domain.utils.functions.UseCaseValidationFunctions.validateIfRepeatCategories;
import static com.example.emazonstock.domain.utils.functions.UseCaseValidationFunctions.validateLimitOfCategories;

public class ArticleUseCase implements IArticleServicePort {

    private final IArticlePersistencePort articlePersistencePort;

    public ArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public void saveArticle(Article article) {
        Set<String> categoriesName = article.getCategories().stream()
                .map(Category::getName)
                .collect(Collectors.toSet());
        System.out.println("Antes de validar categorías duplicadas");
        validateIfRepeatCategories(categoriesName.size(), article.getCategories().size());
        validateLimitOfCategories(LIMIT_OF_CATEGORIES_IN_ARTICLE, article.getCategories().size());
        System.out.println("Antes de guardar el artículo");
        articlePersistencePort.saveArticle(article);
    }
}
