package com.hyphencoder.zaikazon.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hyphencoder.zaikazon.Helper.SharedPrefManager;
import com.hyphencoder.zaikazon.Model.UserDataModel;
import com.hyphencoder.zaikazon.R;

public class Login extends AppCompatActivity {
    // All Variables
    TextView register, btn_login, forget_password;
    ImageView img_facebook, img_google;
    TextInputEditText log_email, log_password;

    DatabaseReference databaseReference;
    String inputEmail, inputPassword;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        // Find all view IDs
        btn_login = findViewById(R.id.btn_Login);
        register = findViewById(R.id.register);
        img_facebook = findViewById(R.id.img_facebook);
        img_google = findViewById(R.id.img_google);
        log_email = findViewById(R.id.log_email);
        log_password = findViewById(R.id.log_password);
        forget_password = findViewById(R.id.forget_password);

        // Initialize Firebase reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Register button onClick event
        register.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Registration.class);
            startActivity(intent);
        });

        // Login button onClick event
        btn_login.setOnClickListener(v -> {
            inputEmail = log_email.getText().toString().trim();
            inputPassword = log_password.getText().toString().trim();

            // Validate email and password fields
            if (inputEmail.isEmpty()) {
                log_email.setError("Please enter your email");
                log_email.requestFocus();
                return;
            }

            if (inputPassword.isEmpty()) {
                log_password.setError("Please enter your password");
                log_password.requestFocus();
                return;
            }

            // Call loginData function to authenticate
            loginData();
        });

        // Forget Password button onClick event
        forget_password.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, ForgetPassword.class);
            startActivity(intent);
        });
    }

    void loginData() {
        databaseReference.orderByChild("email").equalTo(inputEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        String savedPassword = userSnapshot.child("password").getValue(String.class);
                        String id = userSnapshot.child("id").getValue(String.class);
                        String name = userSnapshot.child("name").getValue(String.class);
                        String email = userSnapshot.child("email").getValue(String.class);
                        String number = userSnapshot.child("number").getValue(String.class);
                        String address = userSnapshot.child("address").getValue(String.class);
                        String password = userSnapshot.child("password").getValue(String.class);

                        if (savedPassword != null && savedPassword.equals(inputPassword)) {

                            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();


                            UserDataModel userDataModel=new UserDataModel(id,name,email,number,password,address);
                            SharedPrefManager.getInstance(Login.this).setUser(userDataModel);

                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        } else {

                            Toast.makeText(Login.this, "Invalid password", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {

                    Toast.makeText(Login.this, "No user found with this email", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Login.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
