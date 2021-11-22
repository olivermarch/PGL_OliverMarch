package com.example.juegoapostar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.txtNombrePersona);

        findViewById(R.id.btnJugar).setOnClickListener(v ->{

            String nombre = editText.getText().toString();

            Intent intent = new Intent(getApplicationContext(), pantalla_juego.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        });
    }
}