package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wow.diseasediagnosisv2.R;

public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        LinearLayout questions = findViewById(R.id.next);
        questions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent question = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(question);
            }
        });
    }
}