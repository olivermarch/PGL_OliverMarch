package com.example.juegoapostar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class pantalla_juego extends AppCompatActivity {
    Bundle datos;

    private static final int[]  idBotones = {
            R.id.btn0,
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,};

    private  Button [] boton = new Button[idBotones.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        datos = getIntent().getExtras();
        String nombreJugador = datos.getString("nombre");

        findViewById(R.id.btn0).setOnClickListener(v->{setBotones(0);});
        findViewById(R.id.btn1).setOnClickListener(v->{setBotones(1);});
        findViewById(R.id.btn2).setOnClickListener(v->{setBotones(2);});
        findViewById(R.id.btn3).setOnClickListener(v->{setBotones(3);});
        findViewById(R.id.btn4).setOnClickListener(v->{setBotones(4);});
        findViewById(R.id.btn5).setOnClickListener(v->{setBotones(5);});
        findViewById(R.id.btn6).setOnClickListener(v->{setBotones(6);});
        findViewById(R.id.btn7).setOnClickListener(v->{setBotones(7);});
        findViewById(R.id.btn8).setOnClickListener(v->{setBotones(8);});
        findViewById(R.id.btn9).setOnClickListener(v->{setBotones(9);});

    }

    public void setBotones(int num){

        if (num == 0) {
            for (int i = 0; i < 10; i++) {
                boton[i] = (Button) findViewById(idBotones[i]);
                boton[i].setText(""+i);
            }
        }else{
            for (int i = 0; i < 10; i++) {
                boton[i] = (Button) findViewById(idBotones[i]);
                boton[i].setText(""+num+i);

            }
        }
    }
}