package com.example.where.dataBases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.example.where.object.Boutique;
import com.example.where.object.Produit;
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

    //get all produit
    public List<Produit> getProduit(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"NAME"};
        String tableName="produit";

        qb.setTables(tableName);
        qb.setDistinct(true);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);
        List<Produit> result = new ArrayList<>();
        if (c.moveToFirst()){
            do {

                Produit produit = new Produit();
                //produit.setId(c.getInt(c.getColumnIndex("ID")));
                produit.setName(c.getString(c.getColumnIndex("NAME")));



                result.add(produit);
            }while (c.moveToNext());
        }
        return result;

    }
//Produits + image
    public List<Produit> getProduit2(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();


        String tableName="produit";
        String sql=("SELECT DISTINCT NAME,IMG FROM "+ tableName);
        qb.setTables(tableName);
        Cursor c = db.rawQuery(sql,null);
        List<Produit> result = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                byte[]imageByte= c.getBlob(c.getColumnIndex("IMG"));
                Bitmap image = BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
                Produit produit = new Produit();
                //produit.setId(c.getInt(c.getColumnIndex("ID")));
                produit.setName(c.getString(c.getColumnIndex("NAME")));
                produit.setImg(image);


                result.add(produit);
            }while (c.moveToNext());
        }
        return result;

    }

    //Nom des produits
    public List<String> getProduitName(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();


        String tableName="produit";

        qb.setTables(tableName);
        String sql=("SELECT NAME FROM "+ tableName+ " WHERE NAME IN (SELECT DISTINCT NAME FROM produit)");
        Cursor c = db.rawQuery(sql,null);
        List<String> result = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                result.add(c.getString(c.getColumnIndex("NAME")));
            }while (c.moveToNext());
        }
        return result;

    }

    //get all fav
    public List<Boutique> getFav(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ID","NOM","PRODUIT","VILLE"};
        String tableName="FAVORI";

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

    //insert info
    public long insertFav(String Name, String Produit, String Ville) {
        SQLiteDatabase db=getWritableDatabase();
        String tableName="FAVORI";
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(tableName);
        ContentValues values = new ContentValues();
        values.put("NOM", Name.toString());
        values.put("PRODUIT", Produit.toString());
        values.put("VILLE",Ville.toString());
        return db.insert(tableName, null, values);
    }

    //delte fav
    public void deletFav(String nom){
        SQLiteDatabase db=getWritableDatabase();
        String tableName="FAVORI";
        String colName="NOM";
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(tableName);
        db.execSQL("DELETE FROM " + tableName+ " WHERE "+colName+"='"+nom+"'");
        db.close();
    }


    //Boutique par produit
    public List<Boutique> getMag(String prod){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String tableName="lboutique";
        String tableName2="produit";
        String colName2="BOUTID";
        String colName="ID";
        String colName3="NAME";


        qb.setTables(tableName);
        //Cursor c = db.rawQuery("SELECT * FROM "+ tableName+ " INNER JOIN "+ tableName2+ " ON "+colName2+ " = "+colName+ " WHERE "+colName3+ "= " +prod,null);
        String sql=("SELECT * FROM "+ tableName+ " INNER JOIN "+ tableName2+ " ON "+tableName2+"."+colName2+ " = "+tableName+"."+colName+ " WHERE "+colName3+"='"+prod+"'");
        Cursor c = db.rawQuery(sql,null);
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

    //Boutique par ville
    public List<Boutique> getBoutVille(String ville){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String tableName="lboutique";
        String colName="VILLE";


        qb.setTables(tableName);
        String sql=("SELECT * FROM "+ tableName+ " WHERE "+colName+"='"+ville+"'");
        Cursor c = db.rawQuery(sql,null);
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

    //produit par nom
    public List<Produit> getprodbyname(String prod){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String tableName="produit";
        String colName="NAME";

        qb.setTables(tableName);
        String sql=("SELECT DISTINCT * FROM "+ tableName+ " WHERE "+colName+"='"+prod+"'"+ " LIMIT 1");
        Cursor c = db.rawQuery(sql,null);
        List<Produit> result = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                byte[]imageByte= c.getBlob(c.getColumnIndex("IMG"));
                Bitmap image = BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);

                Produit produit = new Produit();
                produit.setName(c.getString(c.getColumnIndex("NAME")));
                produit.setImg(image);

                result.add(produit);
            }while (c.moveToNext());
        }
        return result;

    }

    //produit d'un magasin
    public List<Produit> getprobymag(long ID){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String tableName="lboutique";
        String tableName2="produit";
        String colName2="BOUTID";
        String colName="ID";
        String colName3="NAME";


        qb.setTables(tableName);

        String sql=("SELECT  produit.NAME,produit.IMG,produit.DESC,produit.PRIX FROM "+ tableName2+ " INNER JOIN "+ tableName+ " ON "+tableName2+"."+colName2+ " = "+tableName+"."+colName+ " WHERE "+colName2+"='"+ID+"'");
        Cursor c = db.rawQuery(sql,null);
        List<Produit> result = new ArrayList<>();
        if (c.moveToFirst()){
            do {

                byte[]imageByte= c.getBlob(c.getColumnIndex("IMG"));
                Bitmap image = BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);

                Produit produit = new Produit();

                produit.setName(c.getString(c.getColumnIndex("NAME")));
                produit.setImg(image);
                produit.setDescription(c.getString(c.getColumnIndex("DESC")));
                produit.setPrix(c.getString(c.getColumnIndex("PRIX")));

                result.add(produit);
            }while (c.moveToNext());
        }
        return result;

    }

}
