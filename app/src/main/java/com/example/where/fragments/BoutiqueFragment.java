package com.example.where.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.where.ContextMenuRecyclerView;

import com.example.where.Boutique;
import com.example.where.BoutiqueAdapter;
import com.example.where.DataBaseOpenhelp;
import com.example.where.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BoutiqueFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private RecyclerView mRecycle;
    private List<Boutique> boutique;
    private BoutiqueAdapter mAdapt;
    public List<Boutique> fav;
    private DataBaseOpenhelp data;
    private TextView nom;
    private TextView prod;
    private TextView city;


    public BoutiqueFragment() {

    }


    public static BoutiqueFragment newInstance(String param1, String param2) {
        BoutiqueFragment fragment = new BoutiqueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_boutique, container, false);
        nom = view.findViewById(R.id.textView4);
        prod = view.findViewById(R.id.textView5);
        city = view.findViewById(R.id.imageView6);


        //init dataBase
        data = new DataBaseOpenhelp(getActivity());


        mRecycle = view.findViewById(R.id.recycle1);
        registerForContextMenu(mRecycle);

         boutique = new ArrayList<>();
         boutique=  data.getBoutique();


       /* boutiques.add(new Boutique("boutique1", new String[]{"Tomate","Laitue"},"St Denis"));
        boutiques.add(new Boutique("boutique2", new String[]{"Tomate","Oignon"},"St Denis"));
        boutiques.add(new Boutique("boutique3", new String[]{"Tomate","Pomme de terre"},"La Possession"));
        boutiques.add(new Boutique("boutique4", new String[]{"Tomate","Ail"},"St Denis"));
        boutiques.add(new Boutique("boutique5",new String[]{"Tomate","Laitue"},"St Denis"));
        boutiques.add(new Boutique("boutique6", new String[]{"Tomate","Carotte"},"St Denis"));
        boutiques.add(new Boutique("boutique7",new String[]{"Tomate","Laitue"},"St Denis"));
        boutiques.add(new Boutique("boutique8",new String[]{"Tomate","Navet"},"St Denis"));*/

        mAdapt = new BoutiqueAdapter(getActivity(), data.getBoutique());
        fav = new ArrayList<>();


        mRecycle.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecycle.setAdapter(mAdapt);

        registerForContextMenu(mRecycle);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycle = view.findViewById(R.id.recycle1);
        registerForContextMenu(mRecycle);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = item.getOrder();
        String name = boutique.get(position).getName();
        String prod = boutique.get(position).getarticle();
        String city = boutique.get(position).getCity();



        // Boutique boutique=bout;
        // do something!
        //return super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.act_fav:

                //data.insertFav(boutiques.get(position).getName(), boutiques.get(position).getarticle(), boutiques.get(position).getCity());
                data.insertFav(name,prod,city);



                return true;
            case R.id.action_delete:
                Log.i("ContextMenu", "Item 1b was chosen");
                return true;
        }
        return super.onContextItemSelected(item);
    }


}
    




