package com.example.actividad9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;

    float dato1 = 0.0f;
    float dato2 = 0.0f;
    float resultado = 0.0f;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvResultado = findViewById(R.id.tWResultado);
        //Botonees de numeros de la calculadora
        findViewById(R.id.btn0).setOnClickListener(v -> setNumeroEnPantalla(0));
        findViewById(R.id.btn1).setOnClickListener(v -> setNumeroEnPantalla(1));
        findViewById(R.id.btn2).setOnClickListener(v -> setNumeroEnPantalla(2));
        findViewById(R.id.btn3).setOnClickListener(v -> setNumeroEnPantalla(3));
        findViewById(R.id.btn4).setOnClickListener(v -> setNumeroEnPantalla(4));
        findViewById(R.id.btn5).setOnClickListener(v -> setNumeroEnPantalla(5));
        findViewById(R.id.btn6).setOnClickListener(v -> setNumeroEnPantalla(6));
        findViewById(R.id.btn7).setOnClickListener(v -> setNumeroEnPantalla(7));
        findViewById(R.id.btn8).setOnClickListener(v -> setNumeroEnPantalla(8));
        findViewById(R.id.btn9).setOnClickListener(v -> setNumeroEnPantalla(9));

        //Botones de calculos

        findViewById(R.id.btnBorrado).setOnClickListener(v -> borrar());
        findViewById(R.id.btnMultiplicacion).setOnClickListener(v -> operar("*"));
        findViewById(R.id.btnDivision).setOnClickListener(v -> operar("/"));
        findViewById(R.id.btnSuma).setOnClickListener(v -> operar("+"));
        findViewById(R.id.btnResta).setOnClickListener(v -> operar("-"));
        findViewById(R.id.btnIgual).setOnClickListener(v -> resolver());
    }

    public void setNumeroEnPantalla(Integer numero){
        int pantalla = Integer.parseInt(tvResultado.getText().toString());
        if (pantalla == 0){
            tvResultado.setText(""+numero);
        }
        else{
            tvResultado.setText(""+pantalla+numero);
        }
    }
    public void borrar(){
        tvResultado.setText("0");
    }
    public void operar(String simbolo){
        dato1 = Float.parseFloat(tvResultado.getText().toString());
        borrar();
        operacion = simbolo;
    }

    public void resolver(){
        dato2 = Float.parseFloat(tvResultado.getText().toString());

        if (operacion == "+") {
            resultado = dato1 + dato2;
            tvResultado.setText(""+ (resultado));
        }else if(operacion == "-"){
            resultado = dato1 - dato2;
            tvResultado.setText(""+ (resultado));
        }else if(operacion == "/") {
            resultado = dato1 / dato2;
            tvResultado.setText("" + (resultado));
        }else if(operacion == "*") {
            resultado = dato1 * dato2;
            tvResultado.setText("" + (resultado));
        }

//        switch (operacion){
//            case division:
//                resultado = dato1 / dato2;
//                tvResultado.setText(""+ (resultado));
//
//            case multipicacion:
//                resultado = dato1 * dato2;
//                tvResultado.setText(""+ (resultado));
//
//            case suma:
//                resultado = dato1 + dato2;
//                tvResultado.setText(""+ (resultado));
//
//            case resta:
//                resultado = dato1 - dato2;
//                tvResultado.setText(""+ (resultado));

//        }
    }
}