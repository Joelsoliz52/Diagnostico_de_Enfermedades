package com.wow.diseasediagnosisv2.model;

public class SymptomToDisease {
    private int id_disease;
    private int id_symptom;

    public SymptomToDisease(int id_disease, int id_symptom){
        this.id_disease = id_disease;
        this.id_symptom = id_symptom;
    }

    public int getId_disease() {
        return id_disease;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }

    public int getId_symptom() {
        return id_symptom;
    }

    public void setId_symptom(int id_symptom) {
        this.id_symptom = id_symptom;
    }
}
