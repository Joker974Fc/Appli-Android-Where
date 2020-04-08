package com.example.where.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.Produit;
import com.example.where.ProduitAdapter;
import com.example.where.R;

import java.util.ArrayList;
import java.util.List;

public class ProduitFtagment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<Produit> prod;
    private ProduitAdapter pAdapt;
    private RecyclerView mRecycle;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProduitFtagment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProduitFtagment newInstance(String param1, String param2) {
        ProduitFtagment fragment = new ProduitFtagment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_produit, container, false);

        mRecycle=(RecyclerView)view.findViewById(R.id.recycle);

        prod = new ArrayList<>();

        prod.add(new Produit("Tomate",false,"img"));
        prod.add(new Produit("Laitue",true,"img"));
        prod.add(new Produit("Carote",false,"img"));

        pAdapt = new ProduitAdapter(prod);

        mRecycle.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecycle.setAdapter(pAdapt);





        // Inflate the layout for this fragment
        return view;
    }
}
