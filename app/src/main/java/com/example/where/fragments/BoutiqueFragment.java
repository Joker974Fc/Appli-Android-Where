package com.example.where.fragments;

import android.content.Context;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.where.ContextMenuRecyclerView;

import com.example.where.Boutique;
import com.example.where.BoutiqueAdapter;
import com.example.where.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BoutiqueFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private RecyclerView mRecycle;
    private List<Boutique> boutiques;
    private BoutiqueAdapter mAdapt;
    public List<Boutique> fav;

    public BoutiqueFragment(){

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



        mRecycle= view.findViewById(R.id.recycle1);
        registerForContextMenu(mRecycle);

        boutiques = new ArrayList<>();

        boutiques.add(new Boutique("boutique1", new String[]{"Tomate","Laitue"},"St Denis"));
        boutiques.add(new Boutique("boutique2", new String[]{"Tomate","Oignon"},"St Denis"));
        boutiques.add(new Boutique("boutique3", new String[]{"Tomate","Pomme de terre"},"La Possession"));
        boutiques.add(new Boutique("boutique4", new String[]{"Tomate","Ail"},"St Denis"));
        boutiques.add(new Boutique("boutique5",new String[]{"Tomate","Laitue"},"St Denis"));
        boutiques.add(new Boutique("boutique6", new String[]{"Tomate","Carotte"},"St Denis"));
        boutiques.add(new Boutique("boutique7",new String[]{"Tomate","Laitue"},"St Denis"));
        boutiques.add(new Boutique("boutique8",new String[]{"Tomate","Navet"},"St Denis"));

        mAdapt = new BoutiqueAdapter(boutiques);

        fav=new ArrayList<>();


        mRecycle.setLayoutManager(new GridLayoutManager(getContext(),2));
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // inflate menu
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
        // handle menu item here
    }








   /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.act_fav:
                // do stuff
                return true;

            case R.id.action_delete:
                // do more stuff
                return true;
        }

        return false;
    }*/



}
