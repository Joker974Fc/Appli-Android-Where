package com.example.where.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.R;
import com.example.where.adapter.BoutiqueAdapter;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.object.Boutique;

import java.util.ArrayList;
import java.util.List;

public class LePortFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private RecyclerView mRecycle;
    private List<Boutique> boutique;
    private BoutiqueAdapter mAdapt;
    private BoutiqueAdapter mAdapt2;
    public List<Boutique> fav;
    private DataBaseOpenhelp data;
    int m=1;






    public LePortFragment() {

    }


    public static LePortFragment newInstance(String param1, String param2) {
        LePortFragment fragment = new LePortFragment();
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



        mAdapt2 = new BoutiqueAdapter(getActivity(), data.getBoutVille("Le PORT"));
        fav = new ArrayList<>();



        mRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));


        mRecycle.setAdapter(mAdapt2);



        registerForContextMenu(mRecycle);


        return view;
    }

    public void setM(int m){
        this.m=m;
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
                data.insertFav(name,prod,city);
                return true;
            case R.id.action_delete:
               data.deletFav(name);
        }
        return super.onContextItemSelected(item);
    }


}





