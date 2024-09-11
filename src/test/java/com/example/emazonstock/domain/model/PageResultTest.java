package com.example.emazonstock.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageResultTest {

    @Test
    void getPageResultInfo() {

        List<String> data = Arrays.asList("item1", "item2", "item3");
        Integer currentPage = 0;
        Integer totalPages = 2;
        long totalItems = 20;
        Integer pageSize = 10;
        String sort = "asc";

        PageResult<String> pageResult = new PageResult<>(
                data,
                currentPage,
                totalPages,
                totalItems,
                pageSize,
                sort);

        assertEquals(data, pageResult.getData(), "PageResult data should match.");
        assertEquals(currentPage, pageResult.getCurrentPage(), "PageResult current page should match.");
        assertEquals(totalPages, pageResult.getTotalPages(), "PageResult total pages should match.");
        assertEquals(totalItems, pageResult.getTotalItems(), "PageResult total items should match.");
        assertEquals(pageSize, pageResult.getPageSize(), "PageResult page size should match.");
        assertEquals(sort, pageResult.getSort(), "PageResult sort match.");

    }

    @Test
    void setPageResultInfo() {

        List<String> data = Arrays.asList("item1", "item2", "item3");
        List<String> newData = Arrays.asList("item1", "item2", "item3");
        Integer currentPage = 0;
        Integer newCurrentPage = 1;
        Integer totalPages = 2;
        Integer newTotalPages = 3;
        long totalItems = 20;
        long newTotalItems = 30;
        Integer pageSize = 10;
        Integer newPageSize = 20;
        String sort = "asc";
        String newSort = "desc";

        PageResult<String> pageResult = new PageResult<>(
                data,
                currentPage,
                totalPages,
                totalItems,
                pageSize,
                sort);
        pageResult.setData(newData);
        pageResult.setCurrentPage(newCurrentPage);
        pageResult.setTotalPages(newTotalPages);
        pageResult.setTotalItems(newTotalItems);
        pageResult.setPageSize(newPageSize);
        pageResult.setSort(newSort);



        assertEquals(newData, pageResult.getData(), "PageResult data should match.");
        assertEquals(newCurrentPage, pageResult.getCurrentPage(), "PageResult current page should match.");
        assertEquals(newTotalPages, pageResult.getTotalPages(), "PageResult total pages should match.");
        assertEquals(newTotalItems, pageResult.getTotalItems(), "PageResult total items should match.");
        assertEquals(newPageSize, pageResult.getPageSize(), "PageResult page size should match.");
        assertEquals(newSort, pageResult.getSort(), "PageResult sort match.");

    }

}