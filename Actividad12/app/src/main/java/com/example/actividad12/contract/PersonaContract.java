package com.example.actividad12;

import android.provider.BaseColumns;

public class PersonaContract {

    public PersonaContract(){
    }
    public static final class PersonaEntry implements BaseColumns{

        //nombre de la tabla
        public final static String TABLE_NAME = "imcdb";
        // id numero para pesos guardados
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_IMC_NOMBRE = "nombre";
        public final static String COLUMN_IMC_EDAD = "edad";
        public final static String COLUMN_IMC_ALTURA = "altura";
        public final static String COLUMN_IMC_PESO = "peso";
        public final static String COLUMN_IMC_IMC = "imc";
        public final static String COLUMN_IMC_SEXO = "sexo";
    }
}
