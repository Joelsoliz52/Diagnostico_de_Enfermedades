package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.wow.diseasediagnosisv2.R;

import java.io.Serializable;

public class DiagnosisActivity extends AppCompatActivity implements Serializable, View.OnClickListener {
    int symptomActual = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);


        LinearLayout add_symptom = findViewById(R.id.add_symptom);
        add_symptom.setOnClickListener(this);

        LinearLayout delete_symptom = findViewById(R.id.delete_symptom);
        delete_symptom.setOnClickListener(this);

        LinearLayout next = findViewById(R.id.next);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_symptom:
                if(symptomActual == 1) {
                    symptomActual = 2;
                    LinearLayout symptom2 = findViewById(R.id.lsymp2);
                    symptom2.setVisibility(View.VISIBLE);
                }else if(symptomActual == 2) {
                    symptomActual = 3;
                    LinearLayout symptom3 = findViewById(R.id.lsymp3);
                    symptom3.setVisibility(View.VISIBLE);
                }else if(symptomActual == 3) {
                    symptomActual = 4;
                    LinearLayout symptom4 = findViewById(R.id.lsymp4);
                    symptom4.setVisibility(View.VISIBLE);
                }else if(symptomActual == 4) {
                    symptomActual = 5;
                    LinearLayout symptom5 = findViewById(R.id.lsymp5);
                    symptom5.setVisibility(View.VISIBLE);
                }else if(symptomActual == 5) {
                    symptomActual = 6;
                    LinearLayout symptom6 = findViewById(R.id.lsymp6);
                    symptom6.setVisibility(View.VISIBLE);
                }else if(symptomActual == 6) {
                    symptomActual = 7;
                    LinearLayout symptom7 = findViewById(R.id.lsymp7);
                    symptom7.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.delete_symptom:
                if(symptomActual == 2) {
                    symptomActual = 1;
                    LinearLayout symptom2 = findViewById(R.id.lsymp2);
                    EditText symp2 = findViewById(R.id.symptom2);
                    symp2.setText("");
                    symptom2.setVisibility(View.GONE);
                }else if(symptomActual == 3) {
                    symptomActual = 2;
                    LinearLayout symptom3 = findViewById(R.id.lsymp3);
                    EditText symp3 =  findViewById(R.id.symptom3);
                    symp3.setText("");
                    symptom3.setVisibility(View.GONE);
                }else if(symptomActual == 4) {
                    symptomActual = 3;
                    EditText symp4 = findViewById(R.id.symptom4);
                    symp4.setText("");
                    LinearLayout symptom4 = findViewById(R.id.lsymp4);
                    symptom4.setVisibility(View.GONE);
                }else if(symptomActual == 5) {
                    symptomActual = 4;
                    EditText symp5 = findViewById(R.id.symptom5);
                    symp5.setText("");
                    LinearLayout symptom5 = findViewById(R.id.lsymp5);
                    symptom5.setVisibility(View.GONE);
                }else if(symptomActual == 6) {
                    symptomActual = 5;
                    EditText symp6 = findViewById(R.id.symptom6);
                    symp6.setText("");
                    LinearLayout symptom6 = findViewById(R.id.lsymp6);
                    symptom6.setVisibility(View.GONE);
                }else if(symptomActual == 7) {
                    symptomActual = 6;
                    EditText symp7 = findViewById(R.id.symptom7);
                    symp7.setText("");
                    LinearLayout symptom7 = findViewById(R.id.lsymp7);
                    symptom7.setVisibility(View.GONE);
                }
                break;
            case R.id.next:
                Intent interview = new Intent(this, InterviewActivity.class);
                startActivity(interview);
                break;
        }
    }

}