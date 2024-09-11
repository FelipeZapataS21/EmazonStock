package com.example.emazonstock.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.emazonstock.application.utils.dtoconstants.CategoryDtoConstants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesRequest {

    @NotNull(message = VALIDATION_NULL_DTO_NAME_CATEGORY)
    @Size(min = 1, max = 50, message = VALIDATION_CATEGORY_NAME_EMPTY_OR_LONGER)
    private String name;

    @NotNull(message = VALIDATION_NULL_DTO_DESCRIPTION_CATEGORY)
    @Size(min = 1, max = 70, message = VALIDATION_CATEGORY_DESCRIPTION_EMPTY_OR_LONGER)
    private String description;

}
