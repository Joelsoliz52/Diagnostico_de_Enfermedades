package com.wow.diseasediagnosisv2.io;

import android.content.Context;
import android.database.Cursor;

import com.wow.diseasediagnosisv2.model.Disease;
import com.wow.diseasediagnosisv2.model.Symptom;
import com.wow.diseasediagnosisv2.model.SymptomToDisease;

import java.util.ArrayList;

public class Diagnosis{
    private DatabaseAccess dataBaseAccess;
    private ArrayList<Disease> diseases = new ArrayList<>();
    private ArrayList<Integer> diseasePoints = new ArrayList<>();
    private ArrayList<Symptom> userSymtoms = new ArrayList<>();
    private ArrayList<SymptomToDisease> relation = new ArrayList<>();
    private ArrayList<Disease> possibleDiseases = new ArrayList<>();

    public Diagnosis(Context context){
        dataBaseAccess = DatabaseAccess.getInstance(context);
    }

    public void initDiagnosis(ArrayList<String> symptoms){
        setUserSymtoms(symptoms);
        setRelation();
        setPossibleDiseases();
        setDiseasePoints();
    }

    public boolean doInterview(){
        for (Integer i : diseasePoints)
            if (i > 2)
                return false;
        return true;
    }

    private void setUserSymtoms(ArrayList<String> symtoms){
        dataBaseAccess.open();
        for(String symptom : symtoms){
            String id = dataBaseAccess.getSymptomID(symptom);
            int idSymptom = Integer.parseInt(id);
            Symptom newSymptom = new Symptom(idSymptom,symptom);
            userSymtoms.add(newSymptom);
        }
        dataBaseAccess.close();
    }

    private void setRelation(){
        dataBaseAccess.open();
        for(Symptom symptom : userSymtoms){
            int idSymptom = symptom.getIdSymptom();
            String idSymptomStr = ""+idSymptom;
            String[] idDiseasesStr = dataBaseAccess.getDiseaseBySimptom(idSymptomStr).split(" ");
            for(String idDiseaseStr : idDiseasesStr) {
                if(!idDiseaseStr.equals("")) {
                    int idDisease = Integer.parseInt(idDiseaseStr);
                    SymptomToDisease newRelation = new SymptomToDisease(idDisease, idSymptom);
                    relation.add(newRelation);
                }
            }
        }
        dataBaseAccess.close();
    }

    private void setPossibleDiseases(){
        dataBaseAccess.open();
        for(SymptomToDisease sTD : relation){
            int id = 0;
            String name = "";
            String description = "";
            String treatment = "";
            String idDisease = ""+sTD.getIdDisease();
            Cursor c = dataBaseAccess.getDisease(idDisease);
            while (c.moveToNext()){
                id = c.getInt(0);
                name = c.getString(1);
                description = c.getString(2);
                treatment = c.getString(3);
            }
            Disease disease = new Disease(id,name,description,treatment);
            possibleDiseases.add(disease);
        }
        dataBaseAccess.close();
    }

    private void setDiseasePoints(){
        int length = possibleDiseases.size();
        for(int i=0; i<length; i++){
            Disease disease = possibleDiseases.get(i);
            if (contains(disease)) {
                int pos = diseases.indexOf(disease);
                int newPoints = diseasePoints.get(pos) + 1;
                diseasePoints.set(pos, newPoints);
            } else {
                diseases.add(disease);
                diseasePoints.add(1);
            }
        }
    }

    public ArrayList<String> getDiseases(){
        ArrayList<String> diseases1 = new ArrayList<>();
        int length = diseasePoints.size();
        for(int i=0; i<length; i++){
            int point = diseasePoints.get(i);
            if (point > 2){
                Disease disease = diseases.get(i);
                String id = ""+disease.getIdDisease();
                diseases1.add(id);
            }

        }
        return diseases1;
    }

    private boolean contains(Disease disease2) {
        for(Disease disease : diseases) {
            String name = disease.getName();
            String name2 = disease2.getName();
            if(name.equals(name2))
                return true;
        }
        return false;
    }
}
