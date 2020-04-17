package com.example.where;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.where.fragments.BoutiqueFragment;
import com.example.where.fragments.DasboardFragment;
import com.example.where.fragments.FavoriteFragment;
import com.example.where.fragments.HomeFragment;
import com.example.where.fragments.ProduitFtagment;
//import com.bottomnavigationview.fragments.NotificationFragment;
//import com.bottomnavigationview.fragments.SmsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import static com.example.where.R.drawable.ic_favorite_red_24dp;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    private ImageButton fav1;

    DataBaseHelp myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        //fav1=findViewById(R.id.imageButton2);

        myDb = new DataBaseHelp(this);

        openFragment(HomeFragment.newInstance("", ""));
        //fav1=findViewById(R.id.toggleButton);





    }



    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_dash:
                            //openFragment(DasboardFragment.newInstance("", ""));
                            Intent activity2 = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(activity2);
                            return true;
                        case R.id.navigation_notif:
                            openFragment(FavoriteFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

    public void open(View v){
        openFragment(BoutiqueFragment.newInstance("", ""));
    }

    public void prod(View view) {
        openFragment(ProduitFtagment.newInstance("", ""));
    }

    public void fav(View view) {
      //fav1.setBackgroundResource(R.drawable.fav);
        //fav1.setBackground(ic_favorite_red_24dp);



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.act_fav:
                // do stuff, like showing settings fragment
                return true;
        }

        return super.onOptionsItemSelected(item); // important line
    }
}
