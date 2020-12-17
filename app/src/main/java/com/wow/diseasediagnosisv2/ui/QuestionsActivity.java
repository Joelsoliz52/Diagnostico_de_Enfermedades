package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.model.ReportDiagnosis;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean nextActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        LinearLayout questions = findViewById(R.id.next);
        questions.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                Intent diagnosis = new Intent(this, DiagnosisActivity.class);
                createReport();
                if(nextActivity){
                    startActivity(diagnosis);
                }
                break;
        }
    }

    private void createReport(){
        RadioButton woman = findViewById(R.id.womanPatient);
        RadioButton man = findViewById(R.id.manPatient);
        EditText age = findViewById(R.id.agePatient);
        String userAg = age.getText().toString();
        int userAge = Integer.parseInt(userAg);
        String userGender;
        isNextActivity(woman.isChecked(), man.isChecked(), userAg);
        if(woman.isChecked())
            userGender = "Mujer";
        else
            userGender = "Hombre";
        ReportDiagnosis rd = ReportDiagnosis.getReport(userGender, userAge);
    }

    private void isNextActivity(boolean isManSelected, boolean isWomanSelected,
                                   String userAge){
        nextActivity = (isManSelected || isWomanSelected) && !userAge.equals("");
    }
}