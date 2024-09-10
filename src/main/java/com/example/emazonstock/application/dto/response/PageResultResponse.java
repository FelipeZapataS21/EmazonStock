package com.example.emazonstock.application.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResultResponse<T> {

    private List<T> data;
    private Integer currentPage;
    private Integer totalPages;
    private long totalItems;
    private Integer pageSize;
    private String sort;
}
