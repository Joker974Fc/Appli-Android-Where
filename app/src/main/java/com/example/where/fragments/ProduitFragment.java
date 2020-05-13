package com.example.where.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.adapter.BoutiqueAdapter;
import com.example.where.adapter.ProduitAdapter2;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.object.Boutique;
import com.example.where.object.Produit;
import com.example.where.adapter.ProduitAdapter;
import com.example.where.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class ProduitFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private List<Produit> prod;
    private List<Boutique> boutique;

    private ProduitAdapter pAdapt;
    private  BoutiqueAdapter badap;
    private RecyclerView mRecycle;
    private DataBaseOpenhelp data;
    private MaterialSearchBar materialSearchBar;
    List<String> suggest ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProduitFragment() {
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
    public static ProduitFragment newInstance(String param1, String param2) {
        ProduitFragment fragment = new ProduitFragment();
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

        materialSearchBar = (MaterialSearchBar) view.findViewById(R.id.seach);

        materialSearchBar.setLastSuggestions(suggest);
        loadsuggest();
        boutique=new ArrayList<>();
        badap = new BoutiqueAdapter(getActivity(),data.getBoutique());



        pAdapt = new ProduitAdapter(getActivity(),data.getProduit2());
        mRecycle.setLayoutManager(new GridLayoutManager(getActivity(),2));

        mRecycle.setAdapter(pAdapt);
        pAdapt.setOnItemClickListener(new ProduitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                prod.get(position);
                boutique=data.getMag(prod.get(position).getName());

                badap = new BoutiqueAdapter(getActivity(),data.getMag(prod.get(position).getName()));
                mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecycle.setAdapter(badap);

                badap.setOnItemClickListener(new BoutiqueAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        boutique.get(position);
                        boutique=data.getMag(prod.get(position).getName());
                        ProduitAdapter2 padap = new ProduitAdapter2(getActivity(),data.getprobymag(boutique.get(position).getID()));
                        mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                        mRecycle.setAdapter(padap);
                    }
                });
            }
        });
//onClik sur boutique
        badap.setOnItemClickListener(new BoutiqueAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                boutique.get(position);
                ProduitAdapter2 padap = new ProduitAdapter2(getActivity(),data.getprobymag(boutique.get(position).getID()));
                mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecycle.setAdapter(padap);
            }
        });



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
                    pAdapt = new ProduitAdapter(getActivity(),data.getProduit2());
                    mRecycle.setLayoutManager(new GridLayoutManager(getActivity(),2));
                    mRecycle.setAdapter(pAdapt);
                pAdapt.setOnItemClickListener(new ProduitAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        prod.get(position);
                        boutique=data.getMag(prod.get(position).getName());

                        badap = new BoutiqueAdapter(getActivity(),data.getMag(prod.get(position).getName()));
                        mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                        mRecycle.setAdapter(badap);

                        badap.setOnItemClickListener(new BoutiqueAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                boutique=data.getMag(prod.get(position).getName());
                                ProduitAdapter2 padap = new ProduitAdapter2(getActivity(),data.getprobymag(boutique.get(position).getID()));
                                mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                                mRecycle.setAdapter(padap);
                            }
                        });

                    }
                });

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
        if(text==" "){
            pAdapt = new ProduitAdapter(getActivity(),data.getProduit2());
            mRecycle.setAdapter(pAdapt);
        }else {
            pAdapt=new ProduitAdapter(getActivity(),data.getprodbyname(text));
            mRecycle.setAdapter(pAdapt);
            pAdapt.setOnItemClickListener(new ProduitAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    boutique=data.getMag(prod.get(position).getName());

                    badap = new BoutiqueAdapter(getActivity(),data.getMag(prod.get(position).getName()));
                    mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                    mRecycle.setAdapter(badap);

                    badap.setOnItemClickListener(new BoutiqueAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            ProduitAdapter2 padap = new ProduitAdapter2(getActivity(),data.getprobymag(boutique.get(position).getID()));
                            mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                            mRecycle.setAdapter(padap);
                        }
                    });

                }
            });


        }

    }

    private void loadsuggest() {
        suggest=data.getProduitName();
        materialSearchBar.setLastSuggestions(suggest);
    }

//Context Menu
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycle = view.findViewById(R.id.recycle);
        registerForContextMenu(mRecycle);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = item.getOrder();
        String name = boutique.get(position).getName();
        String prod = boutique.get(position).getarticle();
        String city = boutique.get(position).getCity();

        switch (item.getItemId()) {
            case R.id.act_fav:
                data.insertFav(name,prod,city);
                return true;
            case R.id.action_delete:
                data.deletFav(name);
        }
        return super.onContextItemSelected(item);
    }

}
