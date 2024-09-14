package com.example.emazonstock.domain.model;

import java.math.BigDecimal;
import java.util.List;

public class Article{

    private Long articleId;
    private String name;
    private String description;
    private Integer amount;
    private BigDecimal price;
    private Brand brand;
    private List<Category> categories;

    public Article(
            Long articleId,
            String name,
            String description,
            Integer amount,
            BigDecimal price,
            Brand brand,
            List<Category> categories
    ){
      this.articleId = articleId;
      this.name = name;
      this.description = description;
      this.amount = amount;
      this.price = price;
      this.brand = brand;
      this.categories = categories;
    }

    public Long getIdArticle(){return articleId;}

    public void setIdArticle(Long idArticle) {this.articleId = idArticle;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Integer getAmount() {return amount;}

    public void setAmount(Integer amount) {this.amount = amount;}

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public Brand getBrand() {return brand;}

    public void setBrand(Brand brand) {this.brand = brand;}

    public List<Category> getCategories() {return categories;}

    public void setCategories(List<Category> categories) {this.categories = categories;}
}
