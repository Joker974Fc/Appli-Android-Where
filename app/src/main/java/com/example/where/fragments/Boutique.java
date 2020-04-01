package com.example.where.fragments;

public class Boutique {
    private String name;
    private String article;
    private String city;

    public Boutique(String name,String article,String city){
        this.name=name;
        this.article=article;
        this.city=city;
    }

    public String getName() { return name; }

    public String getarticle() { return article; }

    public String getCity() { return city;}

    public void setName(String name) { this.name = name; }

    public void setArticle(String article) { this.article = article; }

    public  void setCity(String city) {this.city=city;}
}
