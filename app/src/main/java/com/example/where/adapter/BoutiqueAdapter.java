package com.example.where.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.object.Boutique;
import com.example.where.R;

import java.util.List;

public class BoutiqueAdapter extends RecyclerView.Adapter<BoutiqueAdapter.MyViewHolder> {

    public Context context;
    private List<Boutique> boutiques;
    private OnItemClickListener mList;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public BoutiqueAdapter(FragmentActivity activity, List<Boutique> boutiques){
        this.boutiques=boutiques;
        this.context=activity;
    }

    public void setOnItemClickListener(BoutiqueAdapter.OnItemClickListener listener){
        mList=listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.boutique_item,parent,false);
        return new MyViewHolder(view,mList);


    }

    private int position;

    public  int getPosition() {
        return position;
    }

    private void setPosition(int position) {
        this.position = position;
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
                setPosition(holder.getAdapterPosition());
                return false;
            }
        });
    }

    @Override
    public int getItemCount(){
        return boutiques.size();
    }

    //public class Favorite


    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,View.OnClickListener {
        private TextView name;
        private TextView article;
        private TextView city;

        MyViewHolder(View view, final BoutiqueAdapter.OnItemClickListener listener) {
            super(view);
            name = view.findViewById(R.id.textView4);
            article = view.findViewById(R.id.textView5);
            city = view.findViewById(R.id.textView6);
           // itemView.setOnClickListener(this);
            view.setOnCreateContextMenuListener(this);
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



        void display(Boutique boutique) {
            name.setText(boutique.getName());
            article.setText(boutique.getarticle());
            city.setText(boutique.getCity());

        }



        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select The Action");
            menu.add(0, R.id.act_fav, getAdapterPosition(), "add favorite");
            menu.add(0, R.id.action_delete, getAdapterPosition(), "delete favorite");



        }


        @Override
        public void onClick(View v) {

        }
    }







}
