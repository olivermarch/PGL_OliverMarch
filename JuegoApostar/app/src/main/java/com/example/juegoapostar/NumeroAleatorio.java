package com.example.juegoapostar;

import java.util.Random;

public class NumeroAleatorio {



    public static int generaAleatorio(){

        Random r = new Random();
        int aleatorio = r.nextInt(99);

        return aleatorio;
    }


}
