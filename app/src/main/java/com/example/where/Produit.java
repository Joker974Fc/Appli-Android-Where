package com.example.where;

import java.util.ArrayList;
import java.util.List;

public class Produit {
    private String name;
    private boolean stock;
    private String img;
   // private List<Boutique> boutiques;

    public Produit(String name, boolean stock, String img){
        this.name=name;
        this.stock=stock;
        this.img=img;
        //this.boutiques= new ArrayList<>();
    }

    public String getName() { return name; }

    public boolean getStock() { return stock; }



    public String getImg() { return img;}

    public void setName(String name) { this.name = name; }

    public void setStock(boolean stock) { this.stock = stock; }

    public  void setIMG(String city) {this.img=img;}
}

