package com.example.where;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.where.adapter.ProduitAdapter;
import com.example.where.object.Boutique;
import com.example.where.object.Produit;

import java.util.ArrayList;
import java.util.List;


public class MainActivity3 extends AppCompatActivity {
    private List<Produit> prod;
    private ProduitAdapter pAdapt;
    private RecyclerView mRecycle;
    private List<Boutique> boutiques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mRecycle=(RecyclerView)findViewById(R.id.recycle);

        boutiques = new ArrayList<>();
        List<Produit>
        prod = new ArrayList<>();
        List<Produit> produits;

        /*
        prod.add(new Produit("Tomate",true,"T"));
        prod.add(new Produit("Laitue",true,"L"));
        prod.add(new Produit("Carotte",true,"C"));
        prod.add(new Produit("Oignon",true,"Oi"));
        prod.add(new Produit("Navet",true,"N"));

        pAdapt = new ProduitAdapter(prod);
        mRecycle.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        mRecycle.setAdapter(pAdapt);
    }

    public Produit(String nom,boolean stock,String img,List list){
        super(nom,stock,img);
        list.add(boutiques.get(3));*/
    }
}
