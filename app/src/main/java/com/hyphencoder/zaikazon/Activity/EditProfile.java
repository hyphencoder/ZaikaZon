package com.hyphencoder.zaikazon.Activity;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.hyphencoder.zaikazon.Helper.SharedPrefManager;
import com.hyphencoder.zaikazon.R;

public class EditProfile extends AppCompatActivity {

    TextInputEditText changeName, changeEmail, changeMobile, changeAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        changeName=findViewById(R.id.change_name);
        changeEmail=findViewById(R.id.change_email);
        changeAddress=findViewById(R.id.change_address);
        changeMobile=findViewById(R.id.change_number);

        if(!SharedPrefManager.getInstance(EditProfile.this).getUser().getName().equalsIgnoreCase("")){

           changeName.setText(SharedPrefManager.getInstance(EditProfile.this).getUser().getName());
           changeEmail.setText(SharedPrefManager.getInstance(EditProfile.this).getUser().getEmail());
           changeMobile.setText(SharedPrefManager.getInstance(EditProfile.this).getUser().getNumber());
           changeAddress.setText(SharedPrefManager.getInstance(EditProfile.this).getUser().getAddress());

        }

    }
}