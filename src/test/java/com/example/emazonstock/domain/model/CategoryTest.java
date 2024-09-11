package com.example.emazonstock.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getCategoryInfo() {

        Long id = 1L;
        String name = "Electronics";
        String description = "Electronics new category";

        Category category = new Category(id, name, description);

        assertEquals(id, category.getCategoryId(), "Category ID should match.");
        assertEquals(name, category.getName(), "Category name should match.");
        assertEquals(description, category.getDescription(), "Category description should match.");

    }

    @Test
    void setCategoryInfo() {
        Long id = 1L;
        Long newId = 2L;

        String name = "Electronics";
        String newName = "Sports";

        String description = "Electronics new category";
        String newDescription = "Sports new category";

        Category category = new Category(id, name, description);
        category.setCategoryId(newId);
        category.setName(newName);
        category.setDescription(newDescription);

        assertEquals(newId, category.getCategoryId(), "Category ID should match.");
        assertEquals(newName, category.getName(), "Category name should match.");
        assertEquals(newDescription, category.getDescription(), "Category description should match.");

    }

}