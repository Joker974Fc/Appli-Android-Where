/*package com.example.where;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelp extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "boutique.db";
    public final String TABLE_NAME ="lboutique";
    public final String COL_1="ID";
    public final String COL_2="NAME";
    public final String COL_3="PRODUCT";
    public final String COL_4="CITY";

    public DataBaseHelp(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRODUCT TEXT,CITY TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
}*/
