package com.hyphencoder.zaikazon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphencoder.zaikazon.R;
import com.hyphencoder.zaikazon.Model.RestroScreenModel;
import com.hyphencoder.zaikazon.Adapter.RestroScreenModelAdapter;

import java.util.ArrayList;
import java.util.List;

public class RestroScreen extends AppCompatActivity {

    RecyclerView reviewrecycler;
    Button addReviewbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_screen);


// Add review btn  code.....

        addReviewbtn=findViewById(R.id.addReviewBtn);

        addReviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RestroScreen.this, ReviewActivity.class);
                startActivity(intent);
            }
        });

        // review recycler codee.......

        reviewrecycler=findViewById(R.id.reviewrecycler);

        List<RestroScreenModel> restroScreenModelList=new ArrayList<>();

        restroScreenModelList.add(new RestroScreenModel("","user","5","","hello"));
        restroScreenModelList.add(new RestroScreenModel("","user","5","","hello"));
        restroScreenModelList.add(new RestroScreenModel("","user","5","","hello"));
        restroScreenModelList.add(new RestroScreenModel("","user","5","","hello"));


        reviewrecycler.setLayoutManager(new LinearLayoutManager(RestroScreen.this,LinearLayoutManager.VERTICAL,false));

        RestroScreenModelAdapter restroScreenModelAdapter=new RestroScreenModelAdapter(RestroScreen.this, restroScreenModelList);
        reviewrecycler.setAdapter(restroScreenModelAdapter);

    }
}