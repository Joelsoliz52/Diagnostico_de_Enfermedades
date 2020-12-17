package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.io.Diagnosis;
import com.wow.diseasediagnosisv2.model.Question;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        LinearLayout quiz = findViewById(R.id.next);
        quiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                Intent questions = new Intent(this, QuestionsActivity.class);
                startActivity(questions);
                break;
        }
    }
}