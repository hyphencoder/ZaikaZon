package com.hyphencoder.zaikazon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphencoder.zaikazon.R;
import com.hyphencoder.zaikazon.Model.RestroScreenModel;
import com.hyphencoder.zaikazon.Adapter.RestroScreenModelAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestroScreen extends AppCompatActivity {

    RecyclerView reviewrecycler;
    Button addReviewbtn;

    ImageView screenImg,favbtn;
    TextView restaurant_name,restro_des,restrolocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restro_screen);

// Add review btn  code.....

        screenImg =findViewById(R.id.screenImg);
        favbtn=findViewById(R.id.favbtn);
        restaurant_name=findViewById(R.id.restaurant_name);
        restro_des=findViewById(R.id.restro_des);
        restrolocation=findViewById(R.id.restrolocation);
        addReviewbtn=findViewById(R.id.addReviewBtn);

    // get img and name ....

        Intent intent=getIntent();
        String name=intent.getStringExtra("restroname");
        String location=intent.getStringExtra("restrolocation");
        String desc=intent.getStringExtra("restrodesc");
        String imguri=intent.getStringExtra("restroimg");

        restaurant_name.setText(name);
        restrolocation.setText(location);
        restro_des.setText(desc);
        Picasso.get().load(imguri).into(screenImg);



        // addReview btn code.....
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