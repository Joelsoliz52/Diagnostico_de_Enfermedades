package com.wow.diseasediagnosisv2.model;

import java.io.Serializable;

public class Disease implements Serializable {
    private int idDisease;
    private String name;
    private String review;
    private String treatment;

    public Disease(int idDisease, String name, String review, String treatment) {
        this.idDisease = idDisease;
        this.name = name;
        this.review = review;
        this.treatment = treatment;
    }

    public int getIdDisease() { return idDisease; }

    public void setIdDisease(int idDisease) { this.idDisease = idDisease; }

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
