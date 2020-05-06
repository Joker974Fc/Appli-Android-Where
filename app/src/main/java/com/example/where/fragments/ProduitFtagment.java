package com.example.where.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.adapter.BoutiqueAdapter;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.object.Produit;
import com.example.where.adapter.ProduitAdapter;
import com.example.where.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

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
    private DataBaseOpenhelp data;
    private MaterialSearchBar materialSearchBar;
    List<String> suggest ;

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
       /* if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_produit, container, false);

        //init dataBase
        data = new DataBaseOpenhelp(getActivity());
        suggest=new ArrayList<>();
        prod=new ArrayList<>();
        prod=data.getProduit();
        mRecycle=(RecyclerView)view.findViewById(R.id.recycle);

        materialSearchBar = view.findViewById(R.id.seach);



        pAdapt = new ProduitAdapter(getActivity(),data.getProduit());

        mRecycle.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecycle.setAdapter(pAdapt);
        pAdapt.setOnItemClickListener(new ProduitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                prod.get(position);
                BoutiqueAdapter badap = new BoutiqueAdapter(getActivity(),data.getMag(prod.get(position).getName()));
                mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecycle.setAdapter(badap);
            }
        });

        materialSearchBar.setHint("seach");
        materialSearchBar.setCardViewElevation(10);
        suggest=data.getProduitName();
        materialSearchBar.setLastSuggestions(suggest);
        loadsuggest();
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> sugg = new ArrayList<>();
                for (String seach:suggest){
                    if(seach.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                        sugg.add(seach);
                }
                materialSearchBar.setLastSuggestions(sugg);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if(!enabled)
                    mRecycle.setAdapter(pAdapt);
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });



        // Inflate the layout for this fragment
        return view;
    }

    private void startSearch(String text) {
        pAdapt=new ProduitAdapter(getActivity(),data.getprodbyname(text));
        mRecycle.setAdapter(pAdapt);
    }

    private void loadsuggest() {
        suggest=data.getProduitName();
        materialSearchBar.setLastSuggestions(suggest);
    }

}
