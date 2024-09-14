package com.example.emazonstock.application.mappers.requestmappers;

import com.example.emazonstock.application.dto.request.article.ToArticleRequest;
import com.example.emazonstock.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleRequestMapper {

    @Mapping(target = "articleId", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "categories", target = "categories")
    Article toArticle(ToArticleRequest articleRequest);

}
