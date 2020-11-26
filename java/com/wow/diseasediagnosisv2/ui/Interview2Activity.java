package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wow.diseasediagnosisv2.R;

public class Interview2Activity extends AppCompatActivity implements View.OnClickListener {
    String[] questions;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview2);

        questions = new String[]{"Hola mundo", "Ayuda por favor", "Dictame eso", "Bienvenido a casa", "Te estare esperando", "Welcome to hell"};

        LinearLayout answer_yes = findViewById(R.id.yes_symptom);
        answer_yes.setOnClickListener(this);

        LinearLayout answer_no = findViewById(R.id.not_symptom);
        answer_no.setOnClickListener(this);

        LinearLayout answer_dont_known = findViewById(R.id.dont_known_symptom);
        answer_dont_known.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yes_symptom:
            case R.id.not_symptom:
            case R.id.dont_known_symptom:
                TextView print_question = findViewById(R.id.question);
                if(i<questions.length)
                    print_question.setText(questions[i]);
                    i++;
                break;
        }
    }
}