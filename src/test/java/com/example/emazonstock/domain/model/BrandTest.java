package com.example.emazonstock.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    @Test
    void getBrandInfo() {

        Long id = 1L;
        String name = "Adidas";
        String description = "Adidas new brand";

        Brand brand = new Brand(id, name, description, null);

        assertEquals(id, brand.getBrandId(), "Brand ID should match.");
        assertEquals(name, brand.getName(), "Brand name should match.");
        assertEquals(description, brand.getDescription(), "Brand description should match.");

    }

    @Test
    void setBrandInfo() {
        Long id = 1L;
        Long newId = 2L;

        String name = "Adidas";
        String newName = "Nike";

        String description = "Adidas new brand";
        String newDescription = "Nike new brand";

        Brand brand = new Brand(id, name, description, null);
        brand.setBrandId(newId);
        brand.setName(newName);
        brand.setDescription(newDescription);

        assertEquals(newId, brand.getBrandId(), "Brand ID should match.");
        assertEquals(newName, brand.getName(), "Brand name should match.");
        assertEquals(newDescription, brand.getDescription(), "Brand description should match.");

    }
}