package com.wow.diseasediagnosisv2.io;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiagnosisApiAdapter {
    private static DiagnosisApiService API_SERVICE;

    public static DiagnosisApiService getApiService() {

        //Ver datos de la petición y resultado obtenido del servidor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //Ruta base de la api
        String baseUrl = "https://tisfcyt.herokuapp.com/controler/";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            API_SERVICE = retrofit.create(DiagnosisApiService.class);
        }

        return API_SERVICE;
    }
}
