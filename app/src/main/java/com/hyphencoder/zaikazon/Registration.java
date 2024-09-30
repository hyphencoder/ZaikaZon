package com.hyphencoder.zaikazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@gmail.com+\\.+[a-z]+";


    // All Variables Declare here....

    TextView btnRegister, login;
    ImageView img_facebook, img_google;
    TextInputEditText enter_name, enter_email, enter_number, enter_password, enter_cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        // All Id's Here .......

        enter_name = findViewById(R.id.enter_name);
        enter_email= findViewById(R.id.enter_email);
        enter_number= findViewById(R.id.enter_number);
        enter_password= findViewById(R.id.enter_password);
        enter_cpassword= findViewById(R.id.enter_cpassword);

        btnRegister=findViewById(R.id.btn_Register);
        login=findViewById(R.id.login);
        img_facebook=findViewById(R.id.img_facebook);
        img_google=findViewById(R.id.img_google);


        //Register btn onClick Event Here...

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()){
                    insert();
                }
            }
        });


        // Login here btn onClick Event here..

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });
    }

    boolean validation(){
        boolean status=true;
        String name=enter_name.getText().toString().trim();
        String email=enter_email.getText().toString().trim();
        String number=enter_number.getText().toString().trim();
        String password=enter_password.getText().toString().trim();
        String cpassword = enter_cpassword.getText().toString().trim();
        if (name.equalsIgnoreCase("")){
            enter_name.setError("Enter Your name");
            enter_name.setFocusable(true);
            status=false;
        } else if (!email.equals(emailPattern)) {
            enter_email.setError("Please enter a valid Email");
            enter_email.setFocusable(true);
            status=false;
        } else if (number.equalsIgnoreCase("")) {
            enter_number.setError("Enter your Number");
            enter_number.setFocusable(true);
            status=false;
        }else if (password.isEmpty()) {
            enter_password.setError("Enter Your Password");
            enter_password.setFocusable(true);
            status=false;
        } else if (!password.equals(cpassword)) {
            enter_cpassword.setError("Confirm your Password");
            enter_cpassword.setFocusable(true);
            status= false;
        }
        return status;
    }

     void insert(){
         String name=enter_name.getText().toString().trim();
         String email=enter_email.getText().toString().trim();
         String number=enter_number.getText().toString().trim();
         String password=enter_password.getText().toString().trim();
         String cpassword = enter_cpassword.getText().toString().trim();


             FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
             DatabaseReference databaseReference=firebaseDatabase.getReference("Users");

             String id = databaseReference.push().getKey();

             UserDataModel user = new UserDataModel(name, email, number, password, cpassword);

             if (id != null) {
                 databaseReference.child(id).setValue(user)
                         .addOnCompleteListener(task -> {
                             if (task.isSuccessful()) {
                                 Toast.makeText(Registration.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

                                 Intent intent = new Intent(Registration.this, MainActivity.class);
                                 startActivity(intent);

                             } else {
                                 Toast.makeText(Registration.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                             }
                         });
             }
             enter_cpassword.setText("");
             enter_password.setText("");
             enter_number.setText("");
             enter_email.setText("");
             enter_name.setText("");
     }
}