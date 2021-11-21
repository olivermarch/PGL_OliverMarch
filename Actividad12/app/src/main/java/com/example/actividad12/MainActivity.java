package com.example.actividad12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText etAltura;
    EditText etEdad;
    EditText etPeso;
    RadioGroup rbSexo;
    RadioButton rbsex;

    Double altura;
    Integer edad;
    Double peso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAltura = findViewById(R.id.txtAltura);
        etEdad = findViewById(R.id.txtEdad);
        etPeso = findViewById(R.id.txtPeso);


        pulsarBoton();

    }

    public void pulsarBoton(){


        findViewById(R.id.btnCalcular).setOnClickListener(v ->{
            obtenerDatos();
            Intent intent = new Intent(getApplicationContext(), IMC_Activity.class);
            intent.putExtra("altura", altura);
            intent.putExtra("edad", edad);
            intent.putExtra("peso", peso);
            //intent.putExtra("sexo", sexo);
            startActivity(intent);
        });

    }

    public  void obtenerDatos () {
        altura = Double.parseDouble(etAltura.getText().toString());
        edad = Integer.parseInt(etEdad.getText().toString());
        peso = Double.parseDouble(etPeso.getText().toString());
    }
}