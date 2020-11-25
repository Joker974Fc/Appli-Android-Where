package com.example.where.dataBases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.fragment.app.FragmentActivity;

import com.example.where.object.Avis;
import com.example.where.object.AvisCont;
import com.example.where.object.Boutique;
import com.example.where.object.Produit;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseOpenhelp2 extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "avis.db";
    private static final int DATABASE_VERSION = 1;
    
    /*public DataBaseOpenhelp2(){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }*/

    //DB Avis
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AvisCont.AvisEntry.TABLE_NAME + " (" +
                    AvisCont.AvisEntry._ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                    AvisCont.AvisEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    AvisCont.AvisEntry.COLUMN_IMAGE + TEXT_TYPE + " )";


    public DataBaseOpenhelp2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);*/

    }

    //affiche
    public Cursor readAllAvis() {
        SQLiteDatabase db = getReadableDatabase();

        return db.query(
                AvisCont.AvisEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    //ajout
    public boolean addAvis(Avis avis) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AvisCont.AvisEntry.COLUMN_TITLE, avis.getTitle());
        values.put(AvisCont.AvisEntry.COLUMN_IMAGE, avis.getImageAsString());
        return db.insert(AvisCont.AvisEntry.TABLE_NAME, null, values) != -1;
    }

}
