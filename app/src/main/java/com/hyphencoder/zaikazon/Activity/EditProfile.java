package com.hyphencoder.zaikazon.Activity;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hyphencoder.zaikazon.Helper.SharedPrefManager;
import com.hyphencoder.zaikazon.Model.UserDataModel;
import com.hyphencoder.zaikazon.R;

import java.util.ArrayList;
import java.util.List;

public class EditProfile extends AppCompatActivity {

    TextInputEditText changeName, changeEmail, changeMobile, changeAddress;
    Button cancel, savebtn, changePhoto;

    DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        cancel = findViewById(R.id.btn_cancel);
        savebtn = findViewById(R.id.btn_save);
        changePhoto = findViewById(R.id.change_photo);

        changeName = findViewById(R.id.change_name);
        changeEmail = findViewById(R.id.change_email);
        changeAddress = findViewById(R.id.change_address);
        changeMobile = findViewById(R.id.change_number);


        // edit profile open hone pr  ...
        showUser();

        // change photo  click.....
        changePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Save btn click.......
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
                finish();
            }
        });

        // Cancel btn click........
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    void showUser() {

        Toast.makeText(this, "Get Data Sucess", Toast.LENGTH_SHORT).show();

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        UserDataModel userDataModel1 = snapshot1.getValue(UserDataModel.class);

                        if (userDataModel1 == null) {
                            Toast.makeText(EditProfile.this, "User data not found", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(EditProfile.this, "Data getting", Toast.LENGTH_SHORT).show();

                            changeName.setText(userDataModel1.getName());
                            changeEmail.setText(userDataModel1.getEmail());
                            changeMobile.setText(userDataModel1.getNumber());
                            changeAddress.setText(userDataModel1.getAddress());
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void updateUser() {
        String na = changeName.getText().toString().trim();
        String em = changeEmail.getText().toString().trim();
        String mo = changeMobile.getText().toString().trim();
        String ad = changeAddress.getText().toString().trim();
        String id = SharedPrefManager.getInstance(this).getUser().getId();
        String pa = SharedPrefManager.getInstance(this).getUser().getPassword();


        UserDataModel updateUser = new UserDataModel(id, na, em, mo, pa, ad);
        dbref.child(SharedPrefManager.getInstance(EditProfile.this).getUser().getId())
                .setValue(updateUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(EditProfile.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                        SharedPrefManager.getInstance(EditProfile.this).setUser(updateUser);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditProfile.this, "Updation not sucess", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}