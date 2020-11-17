package com.example.where;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.where.adapter.AvisAdapter;
import com.example.where.dataBases.DataBaseOpenhelp2;

public class AvisActivity2 extends AppCompatActivity {

    private DataBaseOpenhelp2 dbHelper;
    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avis);

        this.gridView = (GridView) findViewById(R.id.avis_main_grid_view);
        this.dbHelper = new DataBaseOpenhelp2(this);
        this.gridView.setAdapter(new AvisAdapter(this, this.dbHelper.readAllAvis(),true));
        //this.gridView.setEmptyView(findViewById(R.id.activity_main_empty_view));
        //((CursorAdapter)gridView.getAdapter()).swapCursor(this.dbHelper.readAllAvis());
    }

    @Override
    protected void onResume() {
        super.onResume();
        //((CursorAdapter)gridView.getAdapter()).swapCursor(this.dbHelper.readAllAvis());
    }

    public void onBackPressed(){
        Intent activity = new Intent(AvisActivity2.this, MainActivity.class);
        startActivity(activity);
    }
}