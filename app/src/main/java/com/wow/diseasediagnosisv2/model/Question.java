package com.wow.diseasediagnosisv2.model;

public class Question {
    private String question;
    private int idDisease;

    public Question(String question, int idDisease){
        this.question = question;
        this.idDisease = idDisease;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(int idDisease) {
        this.idDisease = idDisease;
    }
}
