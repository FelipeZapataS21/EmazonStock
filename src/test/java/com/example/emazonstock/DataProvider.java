package com.example.emazonstock;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.domain.model.Category;

import java.util.List;

public class DataProvider {

    public static List<Category> categoryListMock(){

        return List.of(
                new Category(1L,"Gamer Laptops","Computers Laptops Gamers for all"),
                new Category(2L,"Electronics", "Computers and something more"),
                new Category(3L,"Sports", "everything you may need in sporting goods ")
        );
    }

    public static List<CategoriesRequest> categoriesRequestListMock(){

        return List.of(
                new CategoriesRequest("Gamer Laptops","Computers Laptops Gamers for all"),
                new CategoriesRequest("Electronics", "Computers and something more"),
                new CategoriesRequest("Sports", "everything you may need in sporting goods ")
        );
    }

    public static Category newCategoryMock(Long id, String name, String description){
        return new Category(id, name, description);
    }
}
