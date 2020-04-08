package com.example.where;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mRecycle;
    private List<Boutique> boutiques;
    private BoutiqueAdapter mAdapt;
    private List<Boutique> fav;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecycle=(RecyclerView)findViewById(R.id.recycle);

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

        mRecycle.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        mRecycle.setAdapter(mAdapt);





    }


    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        fav = new ArrayList<>();
        switch(item.getItemId()) {
            case R.id.act_fav:

            case R.id.action_delete:
                //adapter.remove(adapter.getItem(menuInfo.position));
                return true;
        }
        return super.onContextItemSelected(item);
    }*/

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }





}
