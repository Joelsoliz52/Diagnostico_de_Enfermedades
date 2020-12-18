package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.io.DatabaseAccess;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /////////////
        //Codigo Omar
        Log.d("STATE","AQUi");
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(getApplicationContext(),"Conectado", Toast.LENGTH_LONG).show();
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();
            ArrayList<String> lista = databaseAccess.getActualizaciones();
            databaseAccess.close();
            volleyPost("https://tisfcyt.herokuapp.com/controlador/actualizacionRelacion.php","relacionSE",lista.get(2));
            for (String tmp: lista) {
                Toast.makeText(getApplicationContext(),tmp, Toast.LENGTH_LONG).show();
                Log.d("STATE",tmp);
            }
        }else{
            Toast.makeText(getApplicationContext(),"No conectado", Toast.LENGTH_LONG).show();
        }
        //Fin de codigo
        //////////////

        LinearLayout questions = findViewById(R.id.next);
        questions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent question = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(question);
            }
        });
    }

    public void volleyPost(String url,String tipo, String parametro){
        String postUrl = url;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        try {
            postData.put(tipo, parametro);
        } catch ( JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                Log.d("STATE",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}