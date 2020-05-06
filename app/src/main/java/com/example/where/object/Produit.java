package com.example.where.object;

public class Produit {
    private int id;
    private String name;
    private boolean stock;
    private String img;
   // private List<Boutique> boutiques;

    public Produit(int id, String name, boolean stock, String img){
        this.id = id;
        this.name=name;
        this.stock=stock;
        this.img=img;
        //this.boutiques= new ArrayList<>();
    }

    public Produit(){}

    public String getName() { return name; }

    //public boolean getStock() { return stock; }



    public String getImg() { return img;}

    public void setName(String name) { this.name = name; }

    //public void setStock(boolean stock) { this.stock = stock; }

    public  void setIMG(String city) {this.img=img;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

