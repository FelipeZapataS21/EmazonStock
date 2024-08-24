package com.example.emazonstock;

import com.example.emazonstock.domain.model.Category;

import java.util.List;

public class DataProvider {

    public static List<Category> categoryListMock(){

        return List.of(
                new Category(1L,"Gamer Laptops","Computers Laptops Gamers for all"),
                new Category(2L, "Electronics", "Computers and something more")
        );
    }

    public static Category newCategoryMock(Long id, String name, String description){
        return new Category(id, name, description);
    }
}
