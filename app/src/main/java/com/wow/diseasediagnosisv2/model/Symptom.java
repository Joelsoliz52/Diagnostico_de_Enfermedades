package com.wow.diseasediagnosisv2.model;

public class Symptom {
    private  int idSymptom;
    private String name;

    public Symptom(int idSymptom, String name){
        this.idSymptom = idSymptom;
        this.name = name;
    }

    public int getIdSymptom() {
        return idSymptom;
    }

    public void setIdSymptom(int idSymptom) {
        this.idSymptom = idSymptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
