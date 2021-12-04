package com.example.juegoapostar.contract;

import android.provider.BaseColumns;

public final class JugadorContract {



        public static abstract class  JugadorEntry implements BaseColumns {

            //nombre de la tabla
            public final static String TABLE_NAME = "jugadores";

            public final static String COLUMN_NOMBRE = "nombre";
            public final static String COLUMN_INTENTOS = "intentos";

        }


}
