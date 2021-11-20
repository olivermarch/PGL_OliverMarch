package com.example.actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

        tvResultado = findViewById(R.id.textViewResultado);

    }
    //método onClick
    public void multiplicar(View view) {
        calcularTablaDeMultiplicar();
    }

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