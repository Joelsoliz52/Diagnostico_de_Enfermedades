package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.io.DatabaseAccess;
import com.wow.diseasediagnosisv2.model.Disease;
import com.wow.diseasediagnosisv2.model.SymptomToDisease;

public class DiseaseActivity extends AppCompatActivity {
    private Disease disease;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        String idDisease = getIntent().getExtras().getString("disease");

        setDisease(idDisease);

        TextView name = findViewById(R.id.nameText);
        name.setText(disease.getName());

        TextView description = findViewById(R.id.descriptionText);
        description.setText(disease.getReview());

        TextView treatment = findViewById(R.id.treatmentText);
        treatment.setText(disease.getTreatment());
    }

    private void setDisease(String idDisease){
        DatabaseAccess dataBaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        dataBaseAccess.open();
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
        disease = new Disease(id,name,description,treatment);
        dataBaseAccess.close();
    }
}