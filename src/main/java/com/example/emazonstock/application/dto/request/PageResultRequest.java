package com.example.emazonstock.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.emazonstock.application.utils.DtoCategoryConstants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResultRequest {

    @NotNull(message = VALIDATION_NULL_DTO_CURRENT_PAGE)
    @Min(value = 0, message = VALIDATION_POSITIVE_NUMBER_CURRENT_PAGE)
    private Integer currentPage;

    @NotNull(message = VALIDATION_NULL_DTO_PAGE_SIZE)
    @Min(value = 1, message = VALIDATION_POSITIVE_NUMBER_PAGE_SIZE)
    private Integer pageSize;

    @NotBlank(message = VALIDATION_NULL_DTO_SORT)
    private String sort;
}
