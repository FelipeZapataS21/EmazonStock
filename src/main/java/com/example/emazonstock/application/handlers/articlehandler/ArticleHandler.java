package com.example.emazonstock.application.handlers.articlehandler;

import com.example.emazonstock.application.dto.request.article.StringArticleRequest;
import com.example.emazonstock.application.dto.request.article.ToArticleRequest;
import com.example.emazonstock.application.mappers.requestmappers.ArticleRequestMapper;
import com.example.emazonstock.domain.api.IArticleServicePort;
import com.example.emazonstock.domain.api.IBrandServicePort;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@Transactional
public class ArticleHandler implements IArticleHandler{

    private final ArticleRequestMapper articleRequestMapper;
    private final IArticleServicePort articleServicePort;

    private final IBrandServicePort brandServicePort;
    private final ICategoryServicePort categoryServicePort;

    @Override
    public void saveArticleInArticles(StringArticleRequest stringArticleRequest){
        Brand brand = brandServicePort.getBrand(stringArticleRequest.getBrand());
        List<Category> categories = stringArticleRequest.getCategories().stream()
                .map(categoryServicePort::getCategory)
                .filter(Objects::nonNull)
                .toList();

        ToArticleRequest articleRequest = new ToArticleRequest(
                stringArticleRequest.getName(),
                stringArticleRequest.getDescription(),
                stringArticleRequest.getAmount(),
                stringArticleRequest.getPrice(),
                brand,
                categories
        );

        articleServicePort.saveArticle(articleRequestMapper.toArticle(articleRequest));
    }
}
