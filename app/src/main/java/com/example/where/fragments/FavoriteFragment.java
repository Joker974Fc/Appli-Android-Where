package com.example.where.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.adapter.ProduitAdapter2;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.object.Boutique;
import com.example.where.object.Fav;
import com.example.where.adapter.FavAdapter;
import com.example.where.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView fRecycle;
    private List<Boutique> boutiques;
    private FavAdapter fAdapt;
    private DataBaseOpenhelp data;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);



        //init dataBase
        data = new DataBaseOpenhelp(getActivity());

        boutiques=new ArrayList<>();
        boutiques=data.getFav();
//recyclerview
        fRecycle= view.findViewById(R.id.recyclef);

//init adapter
        fAdapt = new FavAdapter(getActivity().getApplicationContext(),data.getFav());

        fRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        fRecycle.setAdapter(fAdapt);
//au clique
        fAdapt.setOnItemClickListener(new FavAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                ProduitAdapter2 padap = new ProduitAdapter2(getActivity(),data.getprobymag(boutiques.get(position).getID()));
                fRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                fRecycle.setAdapter(padap);
            }
        });

        registerForContextMenu(fRecycle);

//return la vue
        return view;
    }


    //Context menu
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fRecycle = view.findViewById(R.id.recyclef);
        registerForContextMenu(fRecycle);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = item.getOrder();
        String name = boutiques.get(position).getName();


        switch (item.getItemId()) {
            case R.id.action_delete:
                data.deletFav(name);
                fAdapt = new FavAdapter(getActivity().getApplicationContext(),data.getFav());
                fRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));
                fRecycle.setAdapter(fAdapt);

        }
        return super.onContextItemSelected(item);
    }

}
