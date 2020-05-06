package com.example.where.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.object.Boutique;
import com.example.where.object.Produit;
import com.example.where.R;

import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.MyViewHolder> {
    List<Produit> produits;
    public Context context;
    List<Boutique> boutiques;
    private OnItemClickListener mList;

    public ProduitAdapter(FragmentActivity activity, List<Produit> produit) {
        this.context=activity;
        this.produits=produit;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mList=listener;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.produit_item,parent,false);
        return new  ProduitAdapter.MyViewHolder(view,mList);
    }

    private int position;

    public  int getPosition() {
        return position;
    }

    private void setPosition(int position) {
        this.position = position;
    }


    @Override
    public void onBindViewHolder(final ProduitAdapter.MyViewHolder holder, final int position){
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



        MyViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            name = view.findViewById(R.id.textView7);
            //stock = view.findViewById(R.id.toggleButton2);
            img = view.findViewById(R.id.imageView6);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int pos = getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }

                }
            });
        }

        void display(Produit produits) {
            name.setText(produits.getName());
            //stock.setChecked(produits.getStock());

        }

        @Override
        public void onClick(View v) {
            
        }
    }


}
