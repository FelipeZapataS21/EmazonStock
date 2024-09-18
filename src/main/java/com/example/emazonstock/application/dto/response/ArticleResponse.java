package com.example.emazonstock.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ArticleResponse {

    private String name;
    private String description;
    private Integer amount;
    private BigDecimal price;
    private String brand;
    private List<String> categories;
}
