package com.hyphencoder.zaikazon.Activity;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyphencoder.zaikazon.Helper.SharedPrefManager;
import com.hyphencoder.zaikazon.Model.UserDataModel;
import com.hyphencoder.zaikazon.R;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    TextView btnRegister, login;
    ImageView img_facebook, img_google;
    TextInputEditText enter_name, enter_email, enter_number, enter_password, enter_cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        enter_name = findViewById(R.id.enter_name);
        enter_email = findViewById(R.id.enter_email);
        enter_number = findViewById(R.id.enter_number);
        enter_password = findViewById(R.id.enter_password);
        enter_cpassword = findViewById(R.id.enter_cpassword);

        btnRegister = findViewById(R.id.btn_Register);
        login = findViewById(R.id.login);
        img_facebook = findViewById(R.id.img_facebook);
        img_google = findViewById(R.id.img_google);

        btnRegister.setOnClickListener(v -> {
            if (validation()) {
                registerUser();
            }
        });

        login.setOnClickListener(v -> {
            Intent intent = new Intent(Registration.this, Login.class);
            startActivity(intent);
        });
    }

    boolean validation() {
        boolean status = true;
        String name = enter_name.getText().toString().trim();
        String email = enter_email.getText().toString().trim();
        String number = enter_number.getText().toString().trim();
        String password = enter_password.getText().toString().trim();
        String cpassword = enter_cpassword.getText().toString().trim();

        if (name.isEmpty()) {
            enter_name.setError("Enter Your name");
            enter_name.requestFocus();
            status = false;
        } else if (!Pattern.compile(emailPattern).matcher(email).matches()) {
            enter_email.setError("Please enter a valid Email");
            enter_email.requestFocus();
            status = false;
        } else if (number.isEmpty()) {
            enter_number.setError("Enter your Number");
            enter_number.requestFocus();
            status = false;
        } else if (password.isEmpty()) {
            enter_password.setError("Enter Your Password");
            enter_password.requestFocus();
            status = false;
        } else if (!cpassword.equals(password)) {
            enter_cpassword.setError("Passwords do not match");
            enter_cpassword.requestFocus();
            status = false;
        }

        return status;
    }

    void registerUser() {
        String name = enter_name.getText().toString().trim();
        String email = enter_email.getText().toString().trim();
        String number = enter_number.getText().toString().trim();
        String password = enter_password.getText().toString().trim();
        String address = "";

        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {


                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("Users");

                        String id = databaseReference.push().getKey();

                        UserDataModel user = new UserDataModel(id, name, email, number, password, address);

                        if (id != null) {
                            databaseReference.child(id).setValue(user)
                                    .addOnCompleteListener(innerTask -> {
                                        if (innerTask.isSuccessful()) {
                                            Toast.makeText(Registration.this, "Registration successful", Toast.LENGTH_SHORT).show();

//                                            SharedPrefManager sharedPrefManager=new SharedPrefManager(Registration.this);
//                                            sharedPrefManager.setUser(user);

                                            SharedPrefManager.getInstance(Registration.this).setUser(user);
//                                            String addre= SharedPrefManager.getInstance(Registration.this).getUser().getAddress();

                                            Intent intent = new Intent(Registration.this, MainActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(Registration.this, "Failed to register", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    } else {
                        Toast.makeText(Registration.this, "Registration failed: " , Toast.LENGTH_SHORT).show();
                    }
                });

        // Clear input fields
        enter_name.setText("");
        enter_email.setText("");
        enter_number.setText("");
        enter_password.setText("");
        enter_cpassword.setText("");
    }
}
