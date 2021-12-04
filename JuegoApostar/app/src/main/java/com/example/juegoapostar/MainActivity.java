
package com.example.juegoapostar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.juegoapostar.helper.JugadorDBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    JugadorDBHelper jugadorDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if( jugadorDBHelper == null){
            jugadorDBHelper = JugadorDBHelper.getJugadorDBHelper(getApplicationContext());
        }
        editText = (EditText) findViewById(R.id.txtNombrePersona);
        textView = (TextView) findViewById(R.id.txtResultados);

        String comprobacion = textView.getText().toString();





        findViewById(R.id.btnJugar).setOnClickListener(v ->{

            String nombre = editText.getText().toString();

            Intent intent = new Intent(getApplicationContext(), pantalla_juego.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        });

        verRecords();


    }

    @Override
    protected void onResume() {
        super.onResume();
        verRecords();
    }

    public void verRecords(){
        List<Jugador> jugadores;
        jugadores = jugadorDBHelper.getAll();

        textView.setText("");
        for(Jugador jugador : jugadores){
            textView.append("Jugador: " + jugador.getNombre() + "   número intentos: " + jugador.getIntentos());
            textView.append("\n");

        }
    }
}