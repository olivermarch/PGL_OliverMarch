package com.example.actividad13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    EditText edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        edad = findViewById(R.id.txtEdad);
        WebView webView = (WebView) findViewById(R.id.webV);

        findViewById(R.id.button).setOnClickListener(v ->{
            String name = nombre.getText().toString();
            String lastName = apellido.getText().toString();
            String age = edad.getText().toString();

            String credenciales = name+"\n"
                                + lastName+"\n"
                                + age;
            webView.loadDataWithBaseURL(null,agregarHtml(credenciales),"text/html", "utf-8", null);

        });

    }

      String agregarHtml(String texto){

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
                        "</style>"+

                        "</head>"+
                        "<body>"+
                        "<h1>"+
                        texto +
                        "</h1>"+
                        "</body>"+
                        "</html>";


        return resultado;


    }
}