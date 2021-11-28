package com.example.actividad12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.OutputStreamWriter;

public class IMC_Activity extends AppCompatActivity {


    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        datos = getIntent().getExtras();
        Double datoAltura = datos.getDouble("altura");
        Integer datoEdad = datos.getInt("edad");
        Double datoPeso = datos.getDouble("peso");

        Double imc = datoPeso / (Math.pow(datoAltura,2));

        TextView tv = (TextView) findViewById(R.id.txtIMC);

        String datosPersona = ("Edad: " + datoEdad +" "+ "Altura: " + datoAltura+" metros\n"
                + "Peso: " + datoPeso+" kilos  IMC: "+ String.format("%.2f", imc));

        tv.setText(datosPersona);

        grabar(datosPersona);

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
        finish();


//



    }

}

