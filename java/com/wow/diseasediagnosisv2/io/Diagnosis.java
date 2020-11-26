package com.wow.diseasediagnosisv2.io;

import com.wow.diseasediagnosisv2.model.Disease;
import com.wow.diseasediagnosisv2.model.Symptom;
import com.wow.diseasediagnosisv2.model.SymptomToDisease;

import java.util.ArrayList;

public class Diagnosis {
    ArrayList<Disease> possibleDiseases;
    ArrayList<SymptomToDisease> relation;

    public boolean doInterview(ArrayList<Symptom> symptoms){
        int i, j;
        possibleDiseases = new ArrayList<>();
        symptoms = new ArrayList<>();
        for(i = 0; i < symptoms.size(); i++){
            for(j = 0; j < relation.size(); j++){
                if(symptoms.get(i).getId_symptom() == relation.get(j).getId_symptom())
                    break;
            }
        }
        return false;
    }

    private ArrayList<Symptom> hola(){
        ArrayList<Symptom> symptoms;
        return null;
    }
}
