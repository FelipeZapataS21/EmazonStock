package com.example.emazonstock.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.emazonstock.application.utils.dtoconstants.BrandDtoConstants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandsRequest {

    @NotNull(message = VALIDATION_NULL_DTO_NAME_BRAND)
    @Size(min = 1, max = 50, message = VALIDATION_BRAND_NAME_EMPTY_OR_LONGER)
    private String name;

    @NotNull(message = VALIDATION_NULL_DTO_DESCRIPTION_BRAND)
    @Size(min = 1, max = 120, message = VALIDATION_BRAND_DESCRIPTION_EMPTY_OR_LONGER)
    private String description;
}
