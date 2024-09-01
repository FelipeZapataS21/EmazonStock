package com.example.emazonstock.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesRequest {

    @NotNull(message = "Name of Category cannot be empty")
    @Size(min = 1, max = 50, message = "The name of the category cannot be longer than 50 characters")
    private String name;

    @NotNull(message = "Description of Category cannot be empty")
    @Size(min = 1, max = 70, message = "Description of category cannot be longer than 70 characters")
    private String description;

}
