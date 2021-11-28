package com.example.actividad12;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "imc.db";
    private final Context contexto;

    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.contexto = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + "PERSONAS" + " ("
                + " id " + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " nombre " + " TEXT NOT NULL,"
                + // los campos precisos
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if( i1 > i) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "PERSONAS");
            onCreate(sqLiteDatabase);
        }
    }
    //Ejemplo de un insert
//    public long insertarRegistro(SQLiteDatabase db, Persona persona){
//        //Creamos el registro a insertar como objeto ContentValues
//        ContentValues nuevoRegistro = new ContentValues();
//        nuevoRegistro.put("nombre", persona.nombre);
//
//        //se siguen poniendo instrucciones put de los campos que se precise
//        return db.insert("PERSONAS", null, nuevoRegistro);
//    }
}
