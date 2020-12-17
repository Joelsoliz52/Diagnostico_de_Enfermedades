package com.wow.diseasediagnosisv2.model;


public class ReportDiagnosis {
    private String userGender;
    private int userAge;
    private static ReportDiagnosis report;

    public static ReportDiagnosis getReport(String userGender, int userAge){
        if(report == null){
            report = new ReportDiagnosis(userGender,userAge);
        }
        return report;
    }
    private ReportDiagnosis(String userGender, int userAge){
        this.userGender = userGender;
        this.userAge = userAge;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserAge() {
        return userAge;
    }
}
