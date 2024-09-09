package com.example.emazonstock.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.emazonstock.application.utils.DtoCategoryConstants.VALIDATION_NULL_DTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResultRequest {

    @NotNull(message = VALIDATION_NULL_DTO)
    private Integer currentPage;

    @NotNull(message = VALIDATION_NULL_DTO)
    private Integer pageSize;

    @NotBlank(message = VALIDATION_NULL_DTO)
    private String sort;
}
