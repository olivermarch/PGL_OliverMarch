package com.example.actividad12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        findViewById(R.id.btnCalcularIMC).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.btnVerDatos).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Resultados.class);
            startActivity(intent);
        });
    }
}