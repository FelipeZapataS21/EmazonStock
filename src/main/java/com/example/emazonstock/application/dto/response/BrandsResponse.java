package com.example.emazonstock.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandsResponse {
    private Long brandId;
    private String name;
    private String description;
}
