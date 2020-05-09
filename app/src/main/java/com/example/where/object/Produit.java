package com.example.where.object;

import android.graphics.Bitmap;

public class Produit {
    private int id;
    private String name;
    private boolean stock;
    private Bitmap img;
    private String description;
    private String prix;
   // private List<Boutique> boutiques;

    public Produit(int id, String name, boolean stock, Bitmap img, String description, String prix){
        this.id = id;
        this.name=name;
        this.stock=stock;
        this.img=img;
        //this.boutiques= new ArrayList<>();
        this.description = description;
        this.prix = prix;
    }

    public Produit(){}

    public String getName() { return name; }

    //public boolean getStock() { return stock; }



    public Bitmap getImg() { return img;}

    public void setName(String name) { this.name = name; }

    //public void setStock(boolean stock) { this.stock = stock; }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImg(Bitmap img){this.img=img;}

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

