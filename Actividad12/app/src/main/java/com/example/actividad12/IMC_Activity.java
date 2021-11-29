package com.example.actividad12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.OutputStreamWriter;

public class IMC_Activity extends AppCompatActivity {


    Bundle datos;
    // Para SQLite
    BaseDatos baseDatos;

    String nombre;
    Integer datoEdad;
    Double datoAltura;
    Double datoPeso;
    String datoIMC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        datos = getIntent().getExtras();
        datoAltura = datos.getDouble("altura");
        datoEdad = datos.getInt("edad");
        datoPeso = datos.getDouble("peso");

        EditText etNombre;
        EditText etApellido;

        Double imc = datoPeso / (Math.pow(datoAltura,2));

        TextView tv = (TextView) findViewById(R.id.txtIMC);

         etNombre = (EditText) findViewById(R.id.txtNombre);
         etApellido = (EditText) findViewById(R.id.txtApellido);



         datoIMC = String.format("%.2f", imc);

        String datosPersona = ("Edad: " + datoEdad +" "+ "Altura: " + datoAltura+" metros\n"
                + "Peso: " + datoPeso+" kilos  IMC: "+ datoIMC);

        tv.setText(datosPersona);

        findViewById(R.id.btnGrabarDatos).setOnClickListener(v -> {

            nombre = etNombre.getText().toString() + " " + etApellido.getText().toString();

            String datosGrabar = etNombre.getText().toString() + " " + etApellido.getText().toString() + "\n"
                                + datosPersona;
            grabar(datosGrabar);
            insertarDatos();
        });
        findViewById(R.id.btnRegresar).setOnClickListener(v ->{
            finish();
        });


    }
    public void grabar (String textoAGrabar){
        OutputStreamWriter archivo = null;

        try {
            archivo = new OutputStreamWriter(getApplicationContext().openFileOutput("ficheroDatosIMC.txt", MODE_PRIVATE));
            archivo.write(textoAGrabar);
            archivo.flush();
            archivo.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast t = Toast.makeText(getApplicationContext(), "Los datos fueron grabados",Toast.LENGTH_SHORT);
        t.show();
    }

    private void insertarDatos(){
        BaseDatos admin = new BaseDatos(this, BaseDatos.DATABASE_NAME, null, BaseDatos.DATABASE_VERSION);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PersonaContract.PersonaEntry.COLUMN_IMC_NOMBRE, nombre);
        values.put(PersonaContract.PersonaEntry.COLUMN_IMC_EDAD, datoEdad);
        values.put(PersonaContract.PersonaEntry.COLUMN_IMC_ALTURA, datoAltura);
        values.put(PersonaContract.PersonaEntry.COLUMN_IMC_PESO, datoPeso);
        values.put(PersonaContract.PersonaEntry.COLUMN_IMC_IMC, datoIMC);
        BaseDeDatos.insert(PersonaContract.PersonaEntry.TABLE_NAME, null, values);
        BaseDeDatos.close();

    }


}

