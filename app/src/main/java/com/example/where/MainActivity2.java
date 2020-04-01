package com.example.where;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.where.fragments.Boutique;
import com.example.where.fragments.BoutiqueAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mRecycle;
    private List<Boutique> boutiques;
    private BoutiqueAdapter mAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mRecycle = mRecycle.findViewById(R.id.recycle);

        boutiques = new ArrayList<>();

        boutiques.add(new com.example.where.fragments.Boutique("boutique1", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new com.example.where.fragments.Boutique("boutique2", "tomate, brède, haricot","St Denis"));
        boutiques.add(new com.example.where.fragments.Boutique("boutique3", "pomme de terre, cerise","St Suzane"));
        boutiques.add(new com.example.where.fragments.Boutique("boutique4", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new com.example.where.fragments.Boutique("boutique5",  "tomate,laitue,oignon","St Denis"));
        boutiques.add(new com.example.where.fragments.Boutique("boutique6", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique7", "tomate,laitue,oignon","St Denis"));
        boutiques.add(new Boutique("boutique7", "tomate,laitue,oignon","St Denis"));

        mAdapt = new BoutiqueAdapter(boutiques);

        mRecycle.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        mRecycle.setAdapter(mAdapt);
    }
}
