package com.hyphencoder.zaikazon.Activity;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hyphencoder.zaikazon.Adapter.RestroModelAdapter;
import com.hyphencoder.zaikazon.Model.RestroModel;
import com.hyphencoder.zaikazon.R;

import java.util.ArrayList;
import java.util.List;

public class Recommended extends AppCompatActivity {

    RecyclerView recommend_recycler;
    ImageView img_back;
    TextView nearby_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);

        // Back Button...

        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //  Changing text on click
        nearby_text=findViewById(R.id.nearby_text);
         String txt= getIntent().getStringExtra("data");
        nearby_text.setText(txt);


        // recommened recycler view  code............

        recommend_recycler=findViewById(R.id.recommend_recycler);
        recommendShow();


    }

    // Recommend Activity....
    void recommendShow(){

        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Restaurant Name");

        List<RestroModel> restroModelList=new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Log.d("Database Refrences", "Snapshot Exists");

                    restroModelList.clear();

                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        RestroModel restroModel=snapshot1.getValue(RestroModel.class);
                        restroModelList.add(restroModel);
                    }

                    RestroModelAdapter adapter=new RestroModelAdapter(Recommended.this,restroModelList);
                    recommend_recycler.setAdapter(adapter);

                    recommend_recycler.setLayoutManager(new GridLayoutManager(Recommended.this, 2));
                }else {
                    Log.d("Database Refrences", "Snapshot not exixts");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Recommended.this, "Data NOt Show", Toast.LENGTH_SHORT).show();
            }
        });
    }
}