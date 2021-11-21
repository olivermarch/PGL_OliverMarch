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
    Double edad;
    Double peso;
    Double imc;
    String sexo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAltura = findViewById(R.id.txtAltura);
        etEdad = findViewById(R.id.txtEdad);
        etPeso = findViewById(R.id.txtPeso);
        rbSexo = findViewById(R.id.rbSexoTotal);
        rbsex =findViewById(R.id.rbHombre);

        pulsarBoton();

    }

    public void pulsarBoton(){


        findViewById(R.id.btnCalcular).setOnClickListener(v ->{
            obtenerDatos();
            Intent intent = new Intent(getApplicationContext(), IMC_Activity.class);
            intent.putExtra("altura", altura);
            intent.putExtra("edad", edad);
            intent.putExtra("peso", peso);
            intent.putExtra("sexo", sexo);
            startActivity(intent);
        });

    }

    public  void obtenerDatos () {
        altura = Double.parseDouble(etAltura.getText().toString());
        edad = Double.parseDouble(etEdad.getText().toString());
        peso = Double.parseDouble(etPeso.getText().toString());
        sexo = rbsex.getText().toString();
        imc = peso / Math.pow(2, altura);


    }
}