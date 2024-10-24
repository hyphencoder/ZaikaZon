package com.hyphencoder.zaikazon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphencoder.zaikazon.Helper.SharedPrefManager;
import com.hyphencoder.zaikazon.R;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(SharedPrefManager.getInstance(splash_screen.this).checkUserLogin()){
                    Intent intent=new Intent(splash_screen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent=new Intent(splash_screen.this, Login.class);
                    startActivity(intent);
                    finish();
                }


            }
        } , 1000);

    }
}