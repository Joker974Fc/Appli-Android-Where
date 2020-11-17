package com.example.where.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.where.R;
import com.example.where.object.Avis;


public class AvisAdapter extends CursorAdapter {

    public AvisAdapter(Context context, Cursor cursor, boolean autoRequery) {
        super(context, cursor, autoRequery);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.avis_item, viewGroup, false);
        view.setTag(new ViewHolder(view));
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder)view.getTag();

        Avis avis = new Avis(cursor);


        holder.titleTextView.setText(avis.getTitle());
        holder.imageView.setImageBitmap(avis.getImage());
    }



    private class ViewHolder {
        final ImageView imageView;
        final TextView titleTextView;

        ViewHolder(View view) {
            imageView = view.findViewById(R.id.camimg);
            titleTextView = view.findViewById(R.id.camtxt);
        }
    }
}
