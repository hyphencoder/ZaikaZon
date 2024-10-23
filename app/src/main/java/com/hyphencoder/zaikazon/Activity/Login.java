package com.hyphencoder.zaikazon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphencoder.zaikazon.R;

public class Login extends AppCompatActivity {
// All  Variables....
    TextView register, btn_login,forget_password;
    ImageView img_facebook, img_google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // All id's Find here......

        btn_login=findViewById(R.id.btn_Login);
        register=findViewById(R.id.register);
        img_facebook=findViewById(R.id.img_facebook);
        img_google = findViewById(R.id.img_google);



        //register btn onClick event here......
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });


        // Login btn onClick event here....

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // forgetPassword code....

        forget_password=findViewById(R.id.forget_password);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ForgetPassword.class);
                startActivity(intent);
            }
        });
    }
}