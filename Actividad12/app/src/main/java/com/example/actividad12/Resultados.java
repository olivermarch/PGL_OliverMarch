package com.example.actividad12;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {

    EditText busqueda;
    TextView resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        busqueda = (EditText) findViewById(R.id.txtResultados);
        resultados = (TextView) findViewById(R.id.txtResultadosDB);

        findViewById(R.id.btnFiltrar).setOnClickListener(v->{
            leerBaseDatos("oliver");
        });
    }
//    public void leerBaseDatos(String nombre){
//        BaseDatos baseDatos = new BaseDatos(this, BaseDatos.DATABASE_NAME, null, BaseDatos.DATABASE_VERSION);
//        SQLiteDatabase db  = baseDatos.getReadableDatabase();
//        String where = "nombre LIKE ?";
//        String[] whereArgs = {nombre};
//        Cursor fila = db.query(PersonaContract.PersonaEntry.TABLE_NAME, null, where, whereArgs, null, null, null);
//        if (fila != null && fila.moveToFirst()) {
//
//
//                String nombreDB = fila.getString(1); //Nombre
//                int edadDB = fila.getInt(2); //Edad
//                Double alturaDB = fila.getDouble(3); //Altura
//                Double pesoDB = fila.getDouble(4); //Peso
//                Double imcDB = fila.getDouble(5); //imc
//
//            resultados.setText("Nombre: " + nombreDB + "\n"
//                                + "Edad: " + edadDB + " Altura: " + alturaDB
//                                + "Peso: " + pesoDB + " IMC: " + imcDB);
//       }
//    }
public void leerBaseDatos(String nombre){
    BaseDatos baseDatos = new BaseDatos(this, BaseDatos.DATABASE_NAME, null, BaseDatos.DATABASE_VERSION);
    SQLiteDatabase db  = baseDatos.getReadableDatabase();
    String[] projection = {
            PersonaContract.PersonaEntry._ID,
            PersonaContract.PersonaEntry.COLUMN_IMC_NOMBRE,
            PersonaContract.PersonaEntry.COLUMN_IMC_EDAD,
            PersonaContract.PersonaEntry.COLUMN_IMC_ALTURA,
            PersonaContract.PersonaEntry.COLUMN_IMC_PESO,
            PersonaContract.PersonaEntry.COLUMN_IMC_IMC,
    };
    Cursor cursor = db.query(PersonaContract.PersonaEntry.TABLE_NAME, projection, null, null, null, null, null);
    int idColumnIndex = cursor.getColumnIndex(PersonaContract.PersonaEntry._ID);
    int nombreColumnIndex = cursor.getColumnIndex(PersonaContract.PersonaEntry.COLUMN_IMC_NOMBRE);
    int edadColumnIndex = cursor.getColumnIndex( PersonaContract.PersonaEntry.COLUMN_IMC_EDAD);
    int alturaColumnIndex = cursor.getColumnIndex( PersonaContract.PersonaEntry.COLUMN_IMC_ALTURA);
    int pesoColumnIndex = cursor.getColumnIndex( PersonaContract.PersonaEntry.COLUMN_IMC_PESO);
    int imcColumnIndex = cursor.getColumnIndex( PersonaContract.PersonaEntry.COLUMN_IMC_IMC);

    while (cursor.moveToNext()){
        int currentID = cursor.getInt(idColumnIndex);
        String nombreDB = cursor.getString(nombreColumnIndex);
        int edadDB  = cursor.getInt(edadColumnIndex);
        Double alturaDB  = cursor.getDouble(alturaColumnIndex);
        Double pesoDB  = cursor.getDouble(pesoColumnIndex);
        Double imcDB  = cursor.getDouble(imcColumnIndex);

        resultados.append(("\n" + currentID +" Nombre: " + nombreDB +"\n"
                                + "Edad: " + edadDB + "Altura: " + alturaDB +"\n"
                                + "Peso: " + pesoDB + " IMC: " + imcDB));
    }
    cursor.close();
}

//    public ArrayList<IMC_Activity> buscarRegistro(SQLiteDatabase db, String nombre) {
//        IMC_Activity persona = null;
//        String where = "nombre LIKE ?";
//        String[] whereArgs = {nombre};
//        Cursor c = null;
//        c = db.query("PERSONAS", null, where, whereArgs, null, null, null);
//        ArrayList<IMC_Activity> personas = new ArrayList<>();
//        if (c != null && c.moveToFirst()) {
//            do {
//                persona = new IMC_Activity(
//                        c.getString(1),
//                        c.getString(2),
//                        c.getString(3),
//                        c.getString(4),
//                        c.getString(5));
//                personas.add(persona);
//            } while (c.moveToNext());
//        }
//        c.close();
//        return personas;
//    }


}