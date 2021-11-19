
package com.example.actividad7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView tvResultado;
    int num1 = 0;
    int num2 = 0;
    int aux = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.txtFirst);
        editText2 = findViewById(R.id.txtSecond);

        tvResultado = findViewById(R.id.txtResult);


    }

    public void sumar(View view) {

        num1 = Integer.parseInt(editText1.getText().toString());
        num2 = Integer.parseInt(editText2.getText().toString());

        System.out.println("Este es es el primero " +num1);
        System.out.println("Este es es el segundo " +num2);

        aux = num1 + num2;
        tvResultado.setText("" + aux );
        System.out.println(aux);
    }

}