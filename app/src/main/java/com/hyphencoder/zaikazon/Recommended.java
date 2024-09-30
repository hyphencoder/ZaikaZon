package com.hyphencoder.zaikazon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        List<RestroModel> restroModelList=new ArrayList<>();
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));

        recommend_recycler.setLayoutManager(new GridLayoutManager(Recommended.this,2));

        RestroModelAdapter restroModelAdapter=new RestroModelAdapter(Recommended.this,restroModelList);
        recommend_recycler.setAdapter(restroModelAdapter);


    }
}