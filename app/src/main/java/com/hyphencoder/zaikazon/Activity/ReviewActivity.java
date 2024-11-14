package com.hyphencoder.zaikazon.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hyphencoder.zaikazon.Model.ReviewModel;
import com.hyphencoder.zaikazon.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReviewActivity extends AppCompatActivity {
    String restroid;
    Button submitbtn;
    RatingBar ratingBar;
    EditText feedbackInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ratingBar = findViewById(R.id.ratingBar);
        feedbackInput=findViewById(R.id.feedbackInput);
        submitbtn=findViewById(R.id.submitButton);


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addReview();
            }
        });
    }

    void addReview(){

        DatabaseReference dbreview = FirebaseDatabase.getInstance().getReference("Reviews");
        String msg=feedbackInput.getText().toString().trim();
        float rat = ratingBar.getRating();
        String rating = String.valueOf(rat);

        String reviewId = dbreview.push().getKey();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String time = sdf.format(new Date());

        DatabaseReference dbrestroid = FirebaseDatabase.getInstance().getReference("Restaurant Name");

        dbrestroid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){


                    if (restroid!=null){
                        Toast.makeText(ReviewActivity.this, "Id get", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ReviewActivity.this, "Id not get", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        ReviewModel reviewModel = new ReviewModel(reviewId,rating,msg,time, restroid);

        dbreview.child(reviewId).setValue(reviewModel);

        Toast.makeText(ReviewActivity.this, "Feedback Submtted Succesfully: rating: "+rating+", msg: "+msg, Toast.LENGTH_SHORT).show();
        finish();
    }
}