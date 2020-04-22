package com.example.where;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import androidx.fragment.app.FragmentActivity;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOpenhelp extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "boutique.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseOpenhelp(FragmentActivity context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    //get all boutique
    public List<Boutique> getBoutique(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ID","NOM","PRODUIT","VILLE"};
        String tableName="lboutique";

        qb.setTables(tableName);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);
        List<Boutique> result = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                Boutique boutique = new Boutique();
                boutique.setId(c.getInt(c.getColumnIndex("ID")));
                boutique.setName(c.getString(c.getColumnIndex("NOM")));
                boutique.setArticle(c.getString(c.getColumnIndex("PRODUIT")));
                boutique.setCity(c.getString(c.getColumnIndex("VILLE")));
                result.add(boutique);
            }while (c.moveToNext());
        }
        return result;

    }


}
