package com.example.where.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.Boutique;
import com.example.where.BoutiqueAdapter;
import com.example.where.R;

import java.util.ArrayList;
import java.util.List;

public class BoutiqueFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView mRecycle;
    private List<Boutique> boutiques;
    private BoutiqueAdapter mAdapt;
    private List<Boutique> fav;

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
        View view = inflater.inflate(R.layout.fragment_boutique, container, false);

        mRecycle=(RecyclerView)view.findViewById(R.id.recycle);

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

        mRecycle.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecycle.setAdapter(mAdapt);

        return view;
    }
}
