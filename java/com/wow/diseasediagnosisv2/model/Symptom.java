package com.wow.diseasediagnosisv2.model;

public class Symptom {
    private  int id_symptom;
    private String name;

    public Symptom(int id_symptom, String name){
        this.id_symptom = id_symptom;
        this.name = name;
    }

    public int getId_symptom() {
        return id_symptom;
    }

    public void setId_symptom(int id_symptom) {
        this.id_symptom = id_symptom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
