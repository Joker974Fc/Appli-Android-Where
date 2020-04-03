package com.example.where;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mRecycle;
    private List<Boutique> boutiques;
    private BoutiqueAdapter mAdapt;
    private List<Boutique> fav;
    private List<Produit> prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecycle=(RecyclerView)findViewById(R.id.recycle);

        boutiques = new ArrayList<>();

        boutiques.add(new Boutique("boutique1", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique2", "tomate, brède, haricot","St Denis"));
        boutiques.add(new Boutique("boutique3", "pomme de terre, cerise","La Possession"));
        boutiques.add(new Boutique("boutique4", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique5",  "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique6", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique7", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique7", "tomate,laitue,oignon","St Denis"));

        mAdapt = new BoutiqueAdapter(boutiques);

        mRecycle.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        mRecycle.setAdapter(mAdapt);

        prod = new ArrayList<>();

        prod.add(new Produit("Tomate",true,"T"));
        prod.add(new Produit("Laitue",true,"L"));
        prod.add(new Produit("Carote",true,"C"));
        prod.add(new Produit("Oignon",true,"Oi"));
        prod.add(new Produit("Navet",true,"N"));






    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        fav = new ArrayList<>();
        switch(item.getItemId()) {
            case R.id.act_fav:

            case R.id.action_delete:
                //adapter.remove(adapter.getItem(menuInfo.position));
                return true;
        }
        return super.onContextItemSelected(item);
    }





}
