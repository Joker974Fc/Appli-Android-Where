package com.example.where;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.adapter.BoutiqueAdapter;
import com.example.where.dataBases.DataBaseOpenhelp;
import com.example.where.fragments.BoutiqueFragment;
import com.example.where.fragments.DasboardFragment;
import com.example.where.fragments.FavoriteFragment;
import com.example.where.fragments.HomeFragment;
import com.example.where.fragments.LaPossesionFragment;
import com.example.where.fragments.LePortFragment;
import com.example.where.fragments.MapFragment;
import com.example.where.fragments.ProduitFragment;
import com.example.where.fragments.StDenisFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//import com.bottomnavigationview.fragments.NotificationFragment;
//import com.bottomnavigationview.fragments.SmsFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    private ImageButton fav1;
    BoutiqueAdapter boutiqueAdapter;
    DataBaseOpenhelp db;
    RecyclerView recyclerView;

    boolean doubletap = false;



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
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_dash:


                            openFragment(MapFragment.newInstance("",""));

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
        //click.start();
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

    public void cam(View view) {
        Intent activity3 = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(activity3);
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

    @Override
    public void onBackPressed(){
        if(doubletap){
            super.onBackPressed();
            System.exit(0);
        }
        else {
            Toast.makeText(this, R.string.Close,Toast.LENGTH_SHORT).show();
            doubletap=true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubletap = false;
                }
            },500);
        }
    }



}
