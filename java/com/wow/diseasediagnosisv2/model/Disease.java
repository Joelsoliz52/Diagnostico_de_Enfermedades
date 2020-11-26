package com.wow.diseasediagnosisv2.model;

public class Disease {
    private int id_disease;
    private String name;
    private String review;
    private String treatment;

    public Disease(int id_disease, String name, String review, String treatment) {
        this.id_disease = id_disease;
        this.name = name;
        this.review = review;
        this.treatment = treatment;
    }

    public int getId_disease() {
        return id_disease;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
