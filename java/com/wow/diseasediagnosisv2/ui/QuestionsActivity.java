package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.wow.diseasediagnosisv2.R;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // LinearLayout myButton  =  findViewById(R.id.next);
        // myButton.setBackgroundColor(0xff000000);
        LinearLayout quiz = findViewById(R.id.next);
        quiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                Intent quiz = new Intent(this, DiagnosisActivity.class);
                RadioButton woman = findViewById(R.id.womanPatient);
                RadioButton man = findViewById(R.id.manPatient);
                EditText age = findViewById(R.id.agePatient);
                String agePatient = age.getText().toString();
                if((woman.isChecked() || man.isChecked()) && !agePatient.equals("")) {
                    startActivity(quiz);
                }
                break;
        }
    }
}