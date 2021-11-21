package com.example.actividad12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        tv.setText("Edad: " + datoEdad +" "+ "Altura: " + datoAltura+" metros\n"
                    + "Peso: " + datoPeso+" kilos  IMC: "+ String.format("%.2f", imc));

        findViewById(R.id.btnRegresar).setOnClickListener(v ->{
            finish();

        });


    }


    }

