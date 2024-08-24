package com.example.emazonstock.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesRequest {
    private Long categoryId;

    private String name;

    private String description;
}
