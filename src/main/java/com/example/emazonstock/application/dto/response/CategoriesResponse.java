package com.example.emazonstock.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesResponse {
    private Long categoryId;
    private String name;
    private String description;
}
