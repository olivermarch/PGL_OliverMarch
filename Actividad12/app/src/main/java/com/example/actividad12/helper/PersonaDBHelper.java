package com.example.actividad12.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.actividad12.contract.PersonaContract;


public class BaseDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "imc.db";


    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String QUERY = "CREATE TABLE " + PersonaContract.PersonaEntry.TABLE_NAME + " ("
                + PersonaContract.PersonaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PersonaContract.PersonaEntry.COLUMN_IMC_NOMBRE + " TEXT, "
                + PersonaContract.PersonaEntry.COLUMN_IMC_EDAD + " INTEGER, "
                + PersonaContract.PersonaEntry.COLUMN_IMC_ALTURA + " DOUBLE, "
                + PersonaContract.PersonaEntry.COLUMN_IMC_PESO + " DOUBLE, "
                + PersonaContract.PersonaEntry.COLUMN_IMC_IMC + " TEXT);";

        sqLiteDatabase.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i1 > i) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "PERSONAS");
            onCreate(sqLiteDatabase);
        }
    }
}
