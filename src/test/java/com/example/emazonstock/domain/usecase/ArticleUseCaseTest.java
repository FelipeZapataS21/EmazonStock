package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.exceptions.ExceedNumberOfCategories;
import com.example.emazonstock.domain.exceptions.NotRepeatCategoryInArticle;
import com.example.emazonstock.domain.model.Article;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.IArticlePersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleUseCaseTest {

    @Mock
    private IArticlePersistencePort articlePersistencePort;

    @InjectMocks
    private ArticleUseCase articleUseCase;

    @Test
    void saveArticleWithValidArticleShouldCallSaveArticle() {
        // Arrange
        BigDecimal bigDecimal = new BigDecimal("165.9");
        Category category1 = new Category(1L,"Category 1","Description",null);
        Category category2 = new Category(2L,"Category 2","Description",null);
        Brand brand = new Brand(1L,"Brand", "test brand", null);
        Article article = new Article(
                1L,
                "Test Article",
                "Test description",
                30,
                bigDecimal,
                brand,
                List.of(category1, category2));

        articleUseCase.saveArticle(article);

        // Assert
        verify(articlePersistencePort, times(1)).saveArticle(article);
    }

    @Test
    void saveArticleWithRepeatedCategoriesShouldThrowException() {

        BigDecimal bigDecimal = new BigDecimal("165.9");
        Category category1 = new Category(1L,"Category 1","Description",null);
        Brand brand = new Brand(1L,"Brand", "test brand", null);
        Article article = new Article(
                1L,
                "Test Article",
                "Test description",
                30,
                bigDecimal,
                brand,
                List.of(category1, category1));

        // Act & Assert
        assertThrows(NotRepeatCategoryInArticle.class, () -> articleUseCase.saveArticle(article));
        verify(articlePersistencePort, never()).saveArticle(any(Article.class));
    }

    @Test
    void saveArticle_WithTooManyCategories_ShouldThrowException() {
        // Arrange
        Category category1 = new Category(1L,"Category 1","Description",null);
        Category category2 = new Category(2L,"Category 2","Description",null);
        Category category3 = new Category(3L,"Category 3","Description",null);
        Category category4 = new Category(4L,"Category 4","Description",null);
        BigDecimal bigDecimal = new BigDecimal("165.9");
        Brand brand = new Brand(1L,"Brand", "test brand", null);

        Article article = new Article(
                1L,
                "Test Article",
                "Test description",
                30,
                bigDecimal,
                brand,
                List.of(category1, category2, category3, category4));

        // Act & Assert
        assertThrows(ExceedNumberOfCategories.class, () -> articleUseCase.saveArticle(article));
        verify(articlePersistencePort, never()).saveArticle(any(Article.class));
    }
}