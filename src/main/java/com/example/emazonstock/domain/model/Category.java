package com.example.emazonstock.domain.model;

import java.util.List;

public class Category{

    private Long categoryId;
    private String name;
    private String description;

    private List<Article> articles;

    public Category(Long categoryId, String name, String description, List<Article> articles){
        this.categoryId = categoryId;
        this.name = name.trim();
        this.description = description.trim();
        this.articles = articles;
    }

    public Long getCategoryId() {return categoryId;}

    public void setCategoryId(Long categoryId) {this.categoryId = categoryId;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public List<Article> getArticles() {return articles;}

    public void setArticles(List<Article> articles) {this.articles = articles;}
}
