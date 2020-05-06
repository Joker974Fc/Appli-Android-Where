package com.example.where.object;

public class Fav {
    private  long id;
    private String name;
    private String article;
    private String city;

    public Fav(long id, String name, String article, String city){
        this.id=id;
        this.name=name;
        this.article=article;
        this.city=city;

    }

    public Fav(){}

    public long getID() { return id; }

    public String getName() { return name; }

    public String getarticle() {
        /*String liste = Arrays.asList(article).toString();
        return liste;*/
        return article;

    }

    public String getCity() { return city;}

    //public int getTailleArticle(){return article.length;}

    public void setName(String name) { this.name = name; }

    public void setArticle(String article) { this.article = article; }

    public  void setCity(String city) {this.city=city;}

    public void setId (long id){this.id=id;}
}
