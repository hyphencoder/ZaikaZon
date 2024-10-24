package com.hyphencoder.zaikazon.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hyphencoder.zaikazon.R;

public class ReviewActivity extends AppCompatActivity {

    Button submitbtn;

    EditText feedbackInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        feedbackInput=findViewById(R.id.feedbackInput);
        submitbtn=findViewById(R.id.submitButton);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackInput.setText("");
                Toast.makeText(ReviewActivity.this, "Feedback Submtted Succesfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}