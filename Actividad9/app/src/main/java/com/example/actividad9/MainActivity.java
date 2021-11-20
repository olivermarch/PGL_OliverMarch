package com.example.actividad9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvResultado = findViewById(R.id.tWResultado);
        //Botonees de numeros de la calculadora
        findViewById(R.id.btn0).setOnClickListener(v -> setResultado(0));
        findViewById(R.id.btn1).setOnClickListener(v -> setResultado(1));
        findViewById(R.id.btn2).setOnClickListener(v -> setResultado(2));
        findViewById(R.id.btn3).setOnClickListener(v -> setResultado(3));
        findViewById(R.id.btn4).setOnClickListener(v -> setResultado(4));
        findViewById(R.id.btn5).setOnClickListener(v -> setResultado(5));
        findViewById(R.id.btn6).setOnClickListener(v -> setResultado(6));
        findViewById(R.id.btn7).setOnClickListener(v -> setResultado(7));
        findViewById(R.id.btn8).setOnClickListener(v -> setResultado(8));
        findViewById(R.id.btn9).setOnClickListener(v -> setResultado(9));

        //Botones de calculos

        findViewById(R.id.btnBorrado).setOnClickListener(v -> borrar());
        findViewById(R.id.btnMultiplicacion).setOnClickListener(v -> );
        findViewById(R.id.btnDivision).setOnClickListener(v -> );
        findViewById(R.id.btnSuma).setOnClickListener(v -> );
        findViewById(R.id.btnIgual).setOnClickListener(v -> );
        findViewById(R.id.btnResta).setOnClickListener(v -> );



    }

    public void setResultado(Integer numero){
        int pantalla = Integer.parseInt(tvResultado.getText().toString());
        if (pantalla == 0){
            tvResultado.setText(""+numero);
        }
        else{
            tvResultado.setText(""+pantalla+numero);
        }
    }
    public void borrar(){
        tvResultado.setText("");
    }
    public void multiplicar(){

    }
    public void sumar(){

    }


}