package com.wow.diseasediagnosisv2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wow.diseasediagnosisv2.R;
import com.wow.diseasediagnosisv2.io.DatabaseAccess;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    public EditText textNombre;
    public Button btnAgregar;
    public Button btnChange;
    public TextView resultado;
    ArrayList<String> names = new ArrayList<>();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textNombre =(EditText)findViewById(R.id.editNombre);
        btnAgregar =(Button)findViewById(R.id.btnAgregar);
        btnChange =(Button)findViewById(R.id.btnChange);
        resultado = findViewById(R.id.resultado);

        /** btnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DatabaseAccess dataBaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                dataBaseAccess.open();
                String s = textNombre.getText().toString();
                for(int i=0; i<55; i++) {
                    String n = String.valueOf(i);
                    String name = dataBaseAccess.getDescription(n);
                    if(name!=null && !name.equals(""))
                        names.add(name);
                }
                dataBaseAccess.close();
        }}); */

        btnChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(i<55) {
                    resultado.setText(names.get(i));
                    i++;
                }else{
                    i = 0;
                }
            }

            });
    }
}
