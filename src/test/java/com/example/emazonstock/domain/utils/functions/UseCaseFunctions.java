package com.example.emazonstock.domain.utils.functions;

import com.example.emazonstock.domain.model.Category;

public class UseCaseFunctions {

    public static Category categoryInstance(Integer numberOfCategoryMock){
        Long categoryId = numberOfCategoryMock.longValue();
        String categoryName = "Category" + numberOfCategoryMock.toString();
        String categoryDescription = "Description of category " + numberOfCategoryMock.toString();
        return new Category(categoryId,categoryName,categoryDescription,null);
    }

    private UseCaseFunctions(){throw new IllegalStateException("Utility class");}
}
