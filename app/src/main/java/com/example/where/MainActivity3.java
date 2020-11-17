package com.example.where;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import com.example.where.dataBases.DataBaseOpenhelp2;
import com.example.where.object.Avis;

//Camera test

public class MainActivity3 extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 200;
    ImageView img;
    EditText editText;
    Bitmap bitmap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img = (ImageView) findViewById(R.id.imgP);
        editText = (EditText) findViewById(R.id.edit);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // apperçu photo
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }




    }

    @Override
    public void onBackPressed(){
        Intent activity = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(activity);
    }


    //save comentaire
    public void val(View view) {
        img.setDrawingCacheEnabled(true);
        Bitmap imge= ((BitmapDrawable)img.getDrawable()).getBitmap();
        new DataBaseOpenhelp2(this).addAvis(new Avis(editText.getText().toString(), imge));
        img.setDrawingCacheEnabled(false);
        Toast.makeText(this, R.string.avispub,Toast.LENGTH_SHORT).show();
    }

    public void seeavis(View view) {
        Intent myIntent = new Intent(this, AvisActivity2.class);
        startActivity(myIntent);
        /*Intent activity = new Intent(AvisActivity2.this, MainActivity.class);
        startActivity(activity);*/
    }

    //open app photo du tel
    public void open(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
        }
    }




}
