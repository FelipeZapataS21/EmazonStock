package com.example.emazonstock.infrastructure.out.jpa.mapper;

import com.example.emazonstock.domain.model.Article;
import com.example.emazonstock.infrastructure.out.jpa.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleEntityMapper {

    ArticleEntity toEntity(Article article);

    Article toArticle(ArticleEntity articleEntity);
}
