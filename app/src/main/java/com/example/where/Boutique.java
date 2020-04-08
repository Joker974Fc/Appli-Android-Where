package com.example.where;

import java.util.Arrays;

public class Boutique {
    private String name;
    private String[] article;
    private String city;

    public Boutique(String name, String[] article, String city){
        this.name=name;
        this.article=article;
        this.city=city;

    }

    public String getName() { return name; }

    public String getarticle() {
        String liste = Arrays.asList(article).toString();
        return liste;

    }

    public String getCity() { return city;}

    public int getTailleArticle(){return article.length;}

    public void setName(String name) { this.name = name; }

    public void setArticle(String[] article) { this.article = article; }

    public  void setCity(String city) {this.city=city;}
}
