package com.wow.diseasediagnosisv2.io;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public String getSymptom(String idSymptom){
        c = db.rawQuery("select NOMBRE_SINTOMA from sintomas where ID_SINTOMA = "+idSymptom,new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nameSymptom = c.getString(0);
            buffer.append(""+nameSymptom);
        }
        return buffer.toString();
    }

    public String getSymptomID(String symptom){
        c = db.rawQuery("select ID_SINTOMA from sintomas where upper(NOMBRE_SINTOMA) = upper('"+symptom+"')",new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String idSymptom = c.getString(0);
            buffer.append(""+idSymptom);
        }
        return buffer.toString();
    }

    public int getLastIdSymptom(){
        c = db.rawQuery("select ID_SINTOMA from sintomas",new String[]{});
        StringBuffer buffer = new StringBuffer();
        c.moveToLast();
        String idSymptom = c.getString(0);
        buffer.append(""+idSymptom);
        int id_symp = Integer.parseInt(buffer.toString());
        return id_symp;
    }

    public String getDiseaseBySimptom(String idSymptom){
        c = db.rawQuery("select ID_ENFERMEDADES from enfermedad_sintoma where ID_SINTOMA = "+idSymptom,new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String idDisease = c.getString(0);
            buffer.append(" "+idDisease);
        }
        return buffer.toString();
    }

    public Cursor getDisease(String idDisease){
        c = db.rawQuery("select * from enfermedad where ID_ENFERMEDADES = "+idDisease,new String[]{});
        return c;
    }
}