package com.example.where;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Executor executor = Executors.newSingleThreadExecutor();

        final BiometricPrompt biometricPrompt = new BiometricPrompt.Builder(this)
                .setTitle(getString(R.string.TBio))
                .setSubtitle(getString(R.string.SubBio))
                .setNegativeButton("Cancel",executor, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).build();

        Button authentificate = (Button) findViewById(R.id.auth);

        MainActivity2 activity2=this;

        authentificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(new CancellationSignal(), executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                        Intent activity3 = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(activity3);

                    }
                });
            }
        });
    }






}