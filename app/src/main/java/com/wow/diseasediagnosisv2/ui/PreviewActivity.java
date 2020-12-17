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

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity{
    private String[] diseasesId;
    private ArrayList<Disease> diseases = new ArrayList<>();
    private LinearLayout disease2;
    private LinearLayout disease3;
    private LinearLayout disease4;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        final String[] id = {""};
        Intent disease = new Intent(getApplicationContext(), DiseaseActivity.class);
        disease2 = findViewById(R.id.disease2);
        disease3 = findViewById(R.id.disease3);
        disease4 = findViewById(R.id.disease4);
        tv1 = findViewById(R.id.ds1);
        tv2 = findViewById(R.id.ds2);
        tv3 = findViewById(R.id.ds3);
        tv4 = findViewById(R.id.ds4);


        diseasesId = getIntent().getExtras().getString("diseases").split(" ");
        setDiseases();
        textViewDiseases();

        LinearLayout disease1 = findViewById(R.id.disease1);
        disease1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                id[0] = diseasesId[1];
                disease.putExtra("disease", id[0]);
                startActivity(disease);
            }
        });

        disease2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                id[0] = diseasesId[2];
                disease.putExtra("disease", id[0]);
                startActivity(disease);
            }
        });

        disease3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                id[0] = diseasesId[3];
                disease.putExtra("disease", id[0]);
                startActivity(disease);
            }
        });

        disease4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                id[0] = diseasesId[4];
                disease.putExtra("disease", id[0]);
                startActivity(disease);
            }
        });
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

        if(length >= 4) {
            setDisease2();
            setDisease3();
            setDisease4();
        }
    }

    private void setDisease2(){
        Disease disease = diseases.get(1);
        disease2.setVisibility(View.VISIBLE);
        tv2.setText(disease.getName());
    }

    private void setDisease3(){
        Disease disease = diseases.get(2);
        disease3.setVisibility(View.VISIBLE);
        tv3.setText(disease.getName());
    }

    private void setDisease4(){
        Disease disease = diseases.get(3);
        disease4.setVisibility(View.VISIBLE);
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
            if(!idDisease.equals("")) {
                Cursor c = dataBaseAccess.getDisease(idDisease);
                while (c.moveToNext()) {
                    id = c.getInt(0);
                    name = c.getString(1);
                    description = c.getString(2);
                    treatment = c.getString(3);
                }
                Disease disease = new Disease(id, name, description, treatment);
                diseases.add(disease);
            }
        }
        dataBaseAccess.close();
    }
}