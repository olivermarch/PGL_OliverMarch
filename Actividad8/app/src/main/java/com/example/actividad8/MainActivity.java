package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button buttonXML;
    Button buttonListener;
    Button buttonInterface;
    TextView tvResultado;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        buttonXML = findViewById(R.id.btnXML);

        //método Listener
        buttonListener = findViewById(R.id.btnListener);
        buttonListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTablaDeMultiplicar();
            } });

        buttonInterface = (Button) findViewById(R.id.btnInterfaz);
        buttonInterface.setOnClickListener(this);

        tvResultado = findViewById(R.id.textViewResultado);

    }
    //método onClick
    public void multiplicar(View view) {
        calcularTablaDeMultiplicar();
    }

    // Método implementando la interfaz a la clase de la Activity, en nuestro caso la MainActivity
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.btnInterfaz:
                calcularTablaDeMultiplicar();

    }
    }
    //Método que realiza el calculo de las tablas de multiplicar
    public void calcularTablaDeMultiplicar (){

        String resultado = "";
        int factorA = Integer.parseInt(editText.getText().toString());

        for (int i = 1; i <= 10; i++) {

            int producto = i*factorA;
            resultado += factorA + " x " + i + " = " + producto + "\n";
        }
        tvResultado.setText(resultado);
    }



}