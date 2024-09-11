    package com.example.emazonstock.domain.model;

    public class Brand {

        private Long brandId;
        private String name;
        private String description;

        public Brand(Long brandId, String name, String description){
            this.brandId = brandId;
            this.name = name.trim();
            this.description = description.trim();
        }

        public Long getBrandId() {return brandId;}

        public void setBrandId(Long categoryId) {this.brandId = categoryId;}

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}
    }
