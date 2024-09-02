package com.example.emazonstock.domain.model;

public class Category{

    private Long categoryId;
    private String name;
    private String description;

    public Category(Long categoryId, String name, String description){
        this.categoryId = categoryId;
        this.name = name.trim();
        this.description = description.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
