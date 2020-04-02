package com.example.where;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.fragments.Boutique;

import java.util.List;

public class BoutiqueAdapter extends RecyclerView.Adapter<BoutiqueAdapter.MyViewHolder> {


    List<Boutique> boutiques;

    public BoutiqueAdapter(List<Boutique> boutiques){
        this.boutiques=boutiques;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.boutique_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position){
        holder.display(boutiques.get(position));
    }

    @Override
    public int getItemCount(){
        return boutiques.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView article;
        private TextView city;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textView4);
            article = view.findViewById(R.id.textView5);
            city = view.findViewById(R.id.textView6);
        }

        void display(Boutique boutique) {
            name.setText(boutique.getName());
            article.setText(boutique.getarticle());
            city.setText(boutique.getCity());

        }
    }
}
