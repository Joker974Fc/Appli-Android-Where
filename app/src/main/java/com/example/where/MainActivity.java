package com.example.where;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.adapter.BoutiqueAdapter;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.fragments.BoutiqueFragment;
import com.example.where.fragments.FavoriteFragment;
import com.example.where.fragments.HomeFragment;
import com.example.where.fragments.LaPossesionFragment;
import com.example.where.fragments.LePortFragment;
import com.example.where.fragments.ProduitFragment;
//import com.bottomnavigationview.fragments.NotificationFragment;
//import com.bottomnavigationview.fragments.SmsFragment;
import com.example.where.fragments.StDenisFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    private ImageButton fav1;
    BoutiqueAdapter boutiqueAdapter;
    DataBaseOpenhelp db;
    RecyclerView recyclerView;

    //DataBaseHelp myDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        recyclerView=findViewById(R.id.recycle1);
        db=new DataBaseOpenhelp(this);
        BoutiqueFragment fragment = new BoutiqueFragment();

        //fav1=findViewById(R.id.imageButton2);

       // myDb = new DataBaseHelp(this);

        openFragment(HomeFragment.newInstance("", ""));
        //fav1=findViewById(R.id.toggleButton);





    }



    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //ouvrir
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_dash:

                            Intent activity3 = new Intent(MainActivity.this, MainActivity3.class);
                            startActivity(activity3);
                            return true;
                        case R.id.navigation_notif:
                            openFragment(FavoriteFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };


    //button
    public void open(View v){
        BoutiqueFragment boutiqueFragment = new BoutiqueFragment();

        openFragment(BoutiqueFragment.newInstance("", ""));
    }


    public void prod(View view) {
        openFragment(ProduitFragment.newInstance("", ""));
    }
    //image button onClick
    public void saintDenis(View v){
        openFragment(StDenisFragment.newInstance("",""));
    }

    public void laPoss(View view) {
        openFragment(LaPossesionFragment.newInstance("",""));
    }

    public void LePort(View view) {
        openFragment(LePortFragment.newInstance("",""));
    }




   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.act_fav:
                // do stuff, like showing settings fragment
                return true;
        }

        return super.onOptionsItemSelected(item); // important line
    }*/



}
