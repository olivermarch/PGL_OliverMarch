package com.example.juegoapostar;

public class Html {
     Jugador jugador;

    String injectarrHtml(String texto){

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
                        "</style>"+

                        "</head>"+
                        "<body>"+
                        "<h1>"+
                         jugador.getNombre()+
                        "</h1>"+
                        "<p>+" +
                        texto +
                        "</p>"+
                        "</body>"+
                        "</html>";


        return resultado;


    }
}
