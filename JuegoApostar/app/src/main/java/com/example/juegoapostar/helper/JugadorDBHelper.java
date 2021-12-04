package com.example.juegoapostar.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.juegoapostar.Jugador;
import com.example.juegoapostar.contract.JugadorContract;

import java.util.ArrayList;
import java.util.List;

public class JugadorDBHelper extends SQLiteOpenHelper {


    private static JugadorDBHelper jugadorDBHelper;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "jugadas.db";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + JugadorContract.JugadorEntry.TABLE_NAME;

    String QUERY = "CREATE TABLE " + JugadorContract.JugadorEntry.TABLE_NAME + " ("
            + JugadorContract.JugadorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + JugadorContract.JugadorEntry.COLUMN_NOMBRE + " TEXT, "
            + JugadorContract.JugadorEntry.COLUMN_INTENTOS + " INTEGER);";

    //Patrón singleton
    public static JugadorDBHelper getJugadorDBHelper(Context context) {
        if (jugadorDBHelper == null) {
            jugadorDBHelper = new JugadorDBHelper(context);
            jugadorDBHelper.getWritableDatabase();
        }
        return jugadorDBHelper;
    }

    private JugadorDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public Jugador save(Jugador jugador){

        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(JugadorContract.JugadorEntry.COLUMN_NOMBRE, jugador.getNombre());
        values.put(JugadorContract.JugadorEntry.COLUMN_INTENTOS, jugador.getIntentos());

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(JugadorContract.JugadorEntry.TABLE_NAME, null, values);

        jugador.setId((int)newRowId);
        return new Jugador(jugador);

    }

    public List<Jugador> getAll() {
        List<Jugador> jugadores;
        Cursor cursor = null;

        String[] projection = {
                BaseColumns._ID,
                JugadorContract.JugadorEntry.COLUMN_NOMBRE,
                JugadorContract.JugadorEntry.COLUMN_INTENTOS,

        };
        //String selection = ArticuloEntry.NOMBRE + " = ?";
        String selection = null;
        //String selectionArgs[] = { "papel" };
        String selectionArgs[] = null;
        String orderBy = JugadorContract.JugadorEntry.COLUMN_INTENTOS + " ASC";

        cursor = getReadableDatabase()
                .query(
                        JugadorContract.JugadorEntry.TABLE_NAME,  //nombre de la tabla
                        projection,   // array de columnas que queremos
                        selection,
                        selectionArgs,
                        null,
                        null,
                        orderBy
                );


        jugadores = new ArrayList<Jugador>();
        while(cursor.moveToNext()){
            @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(JugadorContract.JugadorEntry._ID)));
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(JugadorContract.JugadorEntry.COLUMN_NOMBRE));
            @SuppressLint("Range") int intentos = cursor.getInt(cursor.getColumnIndex(JugadorContract.JugadorEntry.COLUMN_INTENTOS));

            Jugador jugador = new Jugador(id,nombre,intentos);

            jugadores.add(jugador);

        };
        cursor.close();
        return jugadores;

    }
}
