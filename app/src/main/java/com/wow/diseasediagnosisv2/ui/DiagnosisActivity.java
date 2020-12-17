package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.io.DatabaseAccess;
import com.wow.diseasediagnosisv2.io.Diagnosis;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiagnosisActivity extends AppCompatActivity implements Serializable {
    private int indexSymptom = -1;
    ArrayList<String> allSymptoms;
    ArrayList<AutoCompleteTextView> symptoms = new ArrayList<>();
    ArrayList<LinearLayout> lsymptoms = new ArrayList<>();
    ArrayList<String> symptomsText = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        init();

        LinearLayout add_symptom = findViewById(R.id.add_symptom);
        add_symptom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(indexSymptom < 5) {
                    indexSymptom = indexSymptom + 1;
                    LinearLayout lsymptom = lsymptoms.get(indexSymptom);
                    lsymptom.setVisibility(View.VISIBLE);
                }
            }
        });

        LinearLayout delete_symptom = findViewById(R.id.delete_symptom);
        delete_symptom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(indexSymptom > -1) {
                    symptoms.get(indexSymptom+1).setText("");
                    LinearLayout lsymptom = lsymptoms.get(indexSymptom);
                    lsymptom.setVisibility(View.GONE);
                    indexSymptom -= 1;
                }
            }
        });

        LinearLayout next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = view.getContext();
                Intent interview = new Intent(context, InterviewActivity.class);
                Intent disease = new Intent(context, PreviewActivity.class);
                if (verifySymptoms()) {
                    Diagnosis diagnosis = new Diagnosis(context);
                    diagnosis.initDiagnosis(symptomsText);
                    boolean continueInterview = diagnosis.doInterview();
                    if(continueInterview)
                        startActivity(interview);
                    else {
                        ArrayList<String> diseases = diagnosis.getDiseases();
                        disease.putExtra("diseases", diseases);
                        startActivity(disease);
                    }
                }
            }
        });
    }

    private void init(){
        setSymptoms();
        asignSymptoms();
        setAdapterSymptom();
        asignLayoutsSymptoms();
    }

    private void setSymptoms(){
        ArrayList<String> smptms = getSymptoms();
        allSymptoms = organizedAlphabeticList(smptms);
    }

    private void asignSymptoms() {
        AutoCompleteTextView symptom1 = findViewById(R.id.symptom1);
        AutoCompleteTextView symptom2 = findViewById(R.id.symptom2);
        AutoCompleteTextView symptom3 = findViewById(R.id.symptom3);
        AutoCompleteTextView symptom4 = findViewById(R.id.symptom4);
        AutoCompleteTextView symptom5 = findViewById(R.id.symptom5);
        AutoCompleteTextView symptom6 = findViewById(R.id.symptom6);
        AutoCompleteTextView symptom7 = findViewById(R.id.symptom7);
        symptoms.add(symptom1);
        symptoms.add(symptom2);
        symptoms.add(symptom3);
        symptoms.add(symptom4);
        symptoms.add(symptom5);
        symptoms.add(symptom6);
        symptoms.add(symptom7);
    }

    private void setAdapterSymptom(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, allSymptoms);

        for(AutoCompleteTextView symptom : symptoms)
            symptom.setAdapter(adapter);
    }

    private void asignLayoutsSymptoms(){
        LinearLayout symptom2 = findViewById(R.id.lsymp2);
        LinearLayout symptom3 = findViewById(R.id.lsymp3);
        LinearLayout symptom4 = findViewById(R.id.lsymp4);
        LinearLayout symptom5 = findViewById(R.id.lsymp5);
        LinearLayout symptom6 = findViewById(R.id.lsymp6);
        LinearLayout symptom7 = findViewById(R.id.lsymp7);
        lsymptoms.add(symptom2);
        lsymptoms.add(symptom3);
        lsymptoms.add(symptom4);
        lsymptoms.add(symptom5);
        lsymptoms.add(symptom6);
        lsymptoms.add(symptom7);
    }

    private ArrayList<String> getSymptoms() {
        ArrayList<String> names_symptoms = new ArrayList<>();
        DatabaseAccess dataBaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        dataBaseAccess.open();
        int lastId = dataBaseAccess.getLastIdSymptom();
        for(int i=1; i<=lastId; i++) {
            String n = ""+i;
            String name = dataBaseAccess.getSymptom(n);
            if(name!=null && !name.equals(""))
                names_symptoms.add(name);
        }
        dataBaseAccess.close();
        return names_symptoms;
    }

    private static ArrayList<String> organizedAlphabeticList(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            Collator collator = Collator.getInstance();

            public int compare(String o1, String o2) {
                return collator.compare(o1, o2);
            }
        });
        return list;
    }

    public boolean verifySymptoms() {
        for(int i=-1; i <= indexSymptom; i++){
            AutoCompleteTextView symptom = symptoms.get(i+1);
            symptomsText.add(symptom.getText().toString());
        }

        for(String symptomText : symptomsText) {
            if (symptomText.equals("")) {
                showSymptomEmpty();
                symptomsText.clear();
                return false;
            }
            if (!allSymptoms.contains(symptomText)) {
                showSymptomInvalid();
                symptomsText.clear();
                return false;
            }
        }

        return true;
    }

    private void showSymptomInvalid(){
        AlertDialog.Builder builder = new AlertDialog.Builder(DiagnosisActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        builder.setTitle("");
        builder.setMessage("Sintoma(s) inválido").show();
    }

    private void showSymptomEmpty(){
        AlertDialog.Builder builder = new AlertDialog.Builder(DiagnosisActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        builder.setTitle("");
        builder.setMessage("Campo vacio, si no lo utilizará borrelo.").show();
    }
}