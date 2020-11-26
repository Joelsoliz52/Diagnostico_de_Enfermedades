package com.wow.diseasediagnosisv2.model;

public class Question {
    private String question;
    private int id_disease;

    public Question(String question, int id_disease){
        this.question = question;
        this.id_disease = id_disease;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId_disease() {
        return id_disease;
    }

    public void setId_disease(int id_disease) {
        this.id_disease = id_disease;
    }
}
