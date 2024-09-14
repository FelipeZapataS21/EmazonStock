    package com.example.emazonstock.domain.model;

    import java.util.List;

    public class Brand {

        private Long brandId;
        private String name;
        private String description;

        private List<Article> articles;

        public Brand(Long brandId, String name, String description, List<Article> articles){
            this.brandId = brandId;
            this.name = name.trim();
            this.description = description.trim();
            this.articles = articles;
        }

        public Long getBrandId() {return brandId;}

        public void setBrandId(Long categoryId) {this.brandId = categoryId;}

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}

        public List<Article> getArticles() {return articles;}

        public void setArticles(List<Article> articles) {this.articles = articles;}
    }
