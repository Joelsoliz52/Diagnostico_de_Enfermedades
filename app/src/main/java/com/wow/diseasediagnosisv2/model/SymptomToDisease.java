package com.wow.diseasediagnosisv2.model;

public class SymptomToDisease {
    private int idDisease;
    private int idSymptom;

    public SymptomToDisease(int idDisease, int idSymptom){
        this.idDisease = idDisease;
        this.idSymptom = idSymptom;
    }

    public int getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(int idDisease) {
        this.idDisease = idDisease;
    }

    public int getIdSymptom() {
        return idSymptom;
    }

    public void setIdSymptom(int idSymptom) {
        this.idSymptom = idSymptom;
    }
}
