package com.example.emazonstock.application.dto.request.article;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import static com.example.emazonstock.application.utils.dtoconstants.ArticleDtoConstants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StringArticleRequest {

    @NotNull(message = VALIDATION_NULL_DTO_NAME_ARTICLE)
    private String name;

    @NotNull(message = VALIDATION_NULL_DTO_DESCRIPTION_ARTICLE)
    private String description;

    @NotNull(message = VALIDATION_NULL_DTO_AMOUNT_ARTICLE)
    private Integer amount;

    @NotNull(message = VALIDATION_NULL_DTO_PRICE_ARTICLE)
    private BigDecimal price;

    @NotNull(message = VALIDATION_NULL_DTO_BRAND_ARTICLE)
    private String brand;

    @NotNull(message = VALIDATION_NULL_DTO_CATEGORIES_ARTICLE)
    @NotEmpty(message = "Debe haber por lo menos 1 categoria asociada")
    private List<String> categories;
}
