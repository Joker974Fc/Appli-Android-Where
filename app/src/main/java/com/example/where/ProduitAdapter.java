package com.example.where;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.MyViewHolder> {
    List<Produit> produits;
    public Context context;

    public ProduitAdapter(Context context, List<Produit> produits){
        this.produits=produits;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.produit_item,parent,false);
        return new  ProduitAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProduitAdapter.MyViewHolder holder, int position){
        holder.display(produits.get(position));
    }

    @Override
    public int getItemCount(){
        return produits.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        //private ToggleButton stock;
        private ImageView img;



        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textView7);
            //stock = view.findViewById(R.id.toggleButton2);
            img = view.findViewById(R.id.imageView6);
            itemView.setOnClickListener(this);
        }

        void display(Produit produits) {
            name.setText(produits.getName());
            //stock.setChecked(produits.getStock());

        }

        @Override
        public void onClick(View v) {
            
        }
    }

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
