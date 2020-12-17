package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.io.DatabaseAccess;
import com.wow.diseasediagnosisv2.model.Disease;
import com.wow.diseasediagnosisv2.model.SymptomToDisease;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> diseasesId;
    private ArrayList<Disease> diseases = new ArrayList<>();
    private LinearLayout layout2 = findViewById(R.id.disease2);
    private LinearLayout layout3 = findViewById(R.id.disease3);
    private LinearLayout layout4 = findViewById(R.id.disease4);
    private TextView tv1 = findViewById(R.id.ds1);
    private TextView tv2 = findViewById(R.id.ds2);
    private TextView tv3 = findViewById(R.id.ds3);
    private TextView tv4 = findViewById(R.id.ds4);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        diseasesId = (ArrayList<String>) getIntent().getStringArrayListExtra("diseases");
        setDiseases();
        textViewDiseases();

        LinearLayout next = findViewById(R.id.description);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.description:
                Intent interview2 = new Intent(this, DiseaseActivity.class);
                startActivity(interview2);
                break;
        }
    }

    private void textViewDiseases(){
        int length = diseases.size();
        Disease disease = diseases.get(0);
        tv1.setText(disease.getName());

        if(length == 2) {
            setDisease2();
        }

        if(length == 3) {
            setDisease2();
            setDisease3();
        }

        if(length == 4) {
            setDisease2();
            setDisease3();
            setDisease4();
        }
    }

    private void setDisease2(){
        Disease disease = diseases.get(1);
        layout2.setVisibility(View.VISIBLE);
        tv2.setText(disease.getName());
    }

    private void setDisease3(){
        Disease disease = diseases.get(2);
        layout3.setVisibility(View.VISIBLE);
        tv3.setText(disease.getName());
    }

    private void setDisease4(){
        Disease disease = diseases.get(3);
        layout4.setVisibility(View.VISIBLE);
        tv4.setText(disease.getName());
    }

    private void setDiseases(){
        DatabaseAccess dataBaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        dataBaseAccess.open();
        for(String idDisease : diseasesId){
            int id = 0;
            String name = "";
            String description = "";
            String treatment = "";
            Cursor c = dataBaseAccess.getDisease(idDisease);
            while (c.moveToNext()){
                id = c.getInt(0);
                name = c.getString(1);
                description = c.getString(2);
                treatment = c.getString(3);
            }
            Disease disease = new Disease(id,name,description,treatment);
            diseases.add(disease);
        }
        dataBaseAccess.close();
    }
}