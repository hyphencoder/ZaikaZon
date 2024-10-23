package com.hyphencoder.zaikazon.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphencoder.zaikazon.R;

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



    }
}