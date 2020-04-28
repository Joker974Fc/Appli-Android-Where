package com.example.where;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.MyViewHolder> {

    public Context context;
    private List<Boutique> boutiques;

    public FavAdapter(Context context, List<Boutique> boutiques){
        this.boutiques=boutiques;
        this.context=context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.boutique_item,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        //holder.display(boutiques.get(position));
        holder.name.setText(boutiques.get(position).getName());
        holder.article.setText(boutiques.get(position).getarticle());
        holder.city.setText(boutiques.get(position).getCity());


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(holder.getPosition());
                return false;
            }
        });
    }

    @Override
    public int getItemCount(){
        return boutiques.size();
    }

    //public class Favorite


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private TextView name;
        private TextView article;
        private TextView city;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textView4);
            article = view.findViewById(R.id.textView5);
            city = view.findViewById(R.id.textView6);
           // itemView.setOnClickListener(this);


        }

        void display(Boutique boutique) {
            name.setText(boutique.getName());
            article.setText(boutique.getarticle());
            city.setText(boutique.getCity());

        }



        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(Menu.NONE, R.id.act_fav,
                    Menu.NONE, R.string.add_favorite);
            menu.add(Menu.NONE, R.id.action_delete,
                    Menu.NONE, R.string.je_recherche);

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
