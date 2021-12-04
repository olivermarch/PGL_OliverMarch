package com.example.juegoapostar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.example.juegoapostar.helper.JugadorDBHelper;

import java.util.ArrayList;
import java.util.List;

public class pantalla_juego extends AppCompatActivity {
    Bundle datos;
    Jugador jugador;
    JugadorDBHelper jugadorDBHelper;

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

    final String[] valoresBotones = {"0-9", "10-19", "20-29", "30-39", "40-49", "50-59", "60-69", "70-79", "80-89", "90-99"};

    private  Button [] boton = new Button[idBotones.length];
    int apuesta;
    int aleatorio = NumeroAleatorio.generaAleatorio();
    String nombreJugador;
    int intentos = 0;

    ArrayList<String> resultados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_juego);

        if( jugadorDBHelper == null){
            jugadorDBHelper = JugadorDBHelper.getJugadorDBHelper(getApplicationContext());
        }


        datos = getIntent().getExtras();
        nombreJugador = datos.getString("nombre");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadDataWithBaseURL(null,agregarHtml(""),"text/html", "utf-8", null);

        setAllButtons();

    }

    public void setBotones(int num){

        if (num == 0) {
            for (int i = 0; i < 10; i++) {

                boton[i] = (Button) findViewById(idBotones[i]);
                boton[i].setText(""+i);
                int j = i;
                findViewById(idBotones[i]).setOnClickListener(v->{
                    apuesta = Integer.parseInt(boton[j].getText().toString());
                    String apuestaDato = boton[j].getText().toString();
                    WebView webView = (WebView) findViewById(R.id.webView);
                    intentos++;


                    if(apuesta == aleatorio){
                        apuestaDato = "Ganaste, el número aleatorio es: " + aleatorio;
                        guardarDB();

                        Toast t = Toast.makeText(getApplicationContext(), "Ganaste con el " + apuesta
                                + " y con un total de " + intentos + " intentos.",Toast.LENGTH_LONG);
                        t.show();
                        finish();

                    }if(apuesta > aleatorio){
                        apuestaDato = apuesta + " >  Aleatorio";
                    }if(apuesta < aleatorio) {
                        apuestaDato = apuesta + " <  Aleatorio";
                    }

                    webView.loadDataWithBaseURL(null,agregarHtml(apuestaDato),"text/html", "utf-8", null);

                    for (int k = 0; k < 10; k++) {
                        boton[k] = (Button) findViewById(idBotones[k]);
                        boton[k].setText(""+valoresBotones[k]);
                    }
                    setAllButtons();
                });

            }
        }else{
            for (int i = 0; i < 10; i++) {

                boton[i] = (Button) findViewById(idBotones[i]);
                boton[i].setText(""+num+i);
                int j = i;
                findViewById(idBotones[i]).setOnClickListener(v->{
                    apuesta = Integer.parseInt(boton[j].getText().toString());
                    String apuestaDato = boton[j].getText().toString();
                    WebView webView = (WebView) findViewById(R.id.webView);
                    intentos++;


                    if(apuesta == aleatorio){
                        apuestaDato = "Ganaste, el número aleatorio es: " + aleatorio;
                        guardarDB();

                        Toast t = Toast.makeText(getApplicationContext(), "Ganaste con el " + apuesta
                                + " y con un total de " + intentos + " intentos.",Toast.LENGTH_LONG);
                        t.show();
                        finish();

                    }if(apuesta > aleatorio){
                        apuestaDato = apuesta + " >  Aleatorio";
                    }if(apuesta < aleatorio) {
                        apuestaDato = apuesta + " <  Aleatorio";
                    }
                    webView.loadDataWithBaseURL(null,agregarHtml(apuestaDato),"text/html", "utf-8", null);

                    for (int k = 0; k < 10; k++) {
                        boton[k] = (Button) findViewById(idBotones[k]);
                        boton[k].setText(""+valoresBotones[k]);
                    }
                    setAllButtons();
                });


            }
        }
    }

    public void setAllButtons (){
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

    String agregarHtml(String texto){
        resultados.add(texto);

        String resultadosHtml ="";
        if(resultados != null){
            for (String str: resultados) {
                resultadosHtml += "<tr> <td>" + str + "</td></tr>";
            }
        }


        String resultado =
                "<!DOCTYPE html >"+
                        "<html>"+
                        "<head>"+

                        "<meta charset='utf-8' />"+
                        "<meta name='author' content='Oliver March'/>"+
                        "<meta name='viewport' content='width=device-width, initial-scale=1.0'/>"+
                        "<title>Credenciales de la persona</title>"+

                        "<style type='text/css' media='screen'>"+
                        "*{ text-align: center;}"+
                        "body{background: black;}"+
                        "h1 {color: #DEDCDC; font-style: italic }"+
                        "p {color: white;}"+
                        "h2 {color: white; font-size: 15px; font-weight: bold;} " +
                        ".intentos { color: red; font-size: 25px; font-weight: bold;}" +
                        ".column {\n" +
                        "  float: left;\n" +
                        "  width: 50%;\n" +
                        "  text-align: right !important;" +
                        "  background: green;" +
                        "}\n" +
                        ".column1 {\n" +
                        "  float: left;\n" +
                        "  width: 50%;\n" +
                        "  text-align: left !important;" +
                        "}\n" +
                        "\n" +
                        ".row:after {\n" +
                        "  content: \"\";\n" +
                        "  display: table;\n" +
                        "  clear: both;\n" +
                        "}" +
                        "table {background: #6200ee; color: white; margin: 3px; border-radius: 6px}" +
                        "</style>"+

                        "</head>"+
                        "<body>"+
                        "<h1>"+ "Nombre: " +
                        nombreJugador +
                        "</h1>"+
                        "<div class='row'>" +
                            "<div class='column'><p>Intentos: </p></div>" +
                            "<div class='column1'><h2 class='intentos'>" +intentos+ "</h2></div>" +
                        "</div>" +
                        "<p>" +
                        "<table>"+
                        resultadosHtml +
                        "</table>"+
                        "</p>"+
                        "</body>"+
                        "</html>";


        return resultado;


    }

    public void guardarDB(){
        Jugador jugador = new Jugador();
        jugador.setNombre(nombreJugador);
        try{
            jugador.setIntentos(intentos);
            jugadorDBHelper.save(jugador);

        }catch(Exception ex){}
    }
}