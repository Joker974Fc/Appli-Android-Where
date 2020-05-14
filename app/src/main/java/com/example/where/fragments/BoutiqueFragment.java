package com.example.where.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.adapter.ProduitAdapter;
import com.example.where.adapter.ProduitAdapter2;
import com.example.where.object.Boutique;
import com.example.where.adapter.BoutiqueAdapter;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.R;

import java.util.ArrayList;
import java.util.List;

public class BoutiqueFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private RecyclerView mRecycle;
    private List<Boutique> boutique;
    private BoutiqueAdapter mAdapt;
    private BoutiqueAdapter mAdapt2;
    public List<Boutique> fav;
    private DataBaseOpenhelp data;
    int m=1;






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


        //init dataBase
        data = new DataBaseOpenhelp(getActivity());



        mRecycle = view.findViewById(R.id.recycle1);
        registerForContextMenu(mRecycle);

         boutique = new ArrayList<>();
         boutique=  data.getBoutique();

//init adapter
        mAdapt = new BoutiqueAdapter(getActivity(), data.getBoutique());
        //mAdapt2 = new BoutiqueAdapter(getActivity(), data.getBoutVille("Saint Denis"));
        fav = new ArrayList<>();



        mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycle.setAdapter(mAdapt);
//click on item
        mAdapt.setOnItemClickListener(new BoutiqueAdapter.OnItemClickListener() {
            @Override
        public void onItemClick(int position) {
            boutique.get(position);
            ProduitAdapter2 padap = new ProduitAdapter2(getActivity(),data.getprobymag(boutique.get(position).getID()));
            mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecycle.setAdapter(padap);
        }
    });



        registerForContextMenu(mRecycle);


        return view;
    }


//Context menu
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
                data.insertFav(name,prod,city);
                return true;
            case R.id.action_delete:
               data.deletFav(name);
        }
        return super.onContextItemSelected(item);
    }




}





