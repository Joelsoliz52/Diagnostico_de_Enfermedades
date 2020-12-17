package com.wow.diseasediagnosisv2.io;

import com.wow.diseasediagnosisv2.model.Disease;
import com.wow.diseasediagnosisv2.model.Symptom;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DiagnosisApiService {

    //Llamada a las enfermedades
    @GET("api_enfermedad.php")
    Call<ArrayList<Disease>> getDiseases();

    //Llamada a las enfermedades por sistema
    @GET("api_sintoma.php")
    Call<ArrayList<Symptom>> getSymptoms();
}
