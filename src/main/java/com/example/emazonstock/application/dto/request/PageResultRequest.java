package com.example.emazonstock.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResultRequest {

    private int totalPages;
    private int pageSize;
    private String sort;
}
