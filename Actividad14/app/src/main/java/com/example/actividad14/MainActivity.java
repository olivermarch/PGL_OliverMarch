package com.example.actividad14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_activity);



    }
}

//
//public class MainActivity extends AppCompatActivity {
//
//    PruebaCanvas pruebaCanvas;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.prueba_canvas);
//
//        pruebaCanvas = (PruebaCanvas) findViewById(R.id.canvas);
//
//        pruebaCanvas.setOnTouchListener((view, motionEvent) -> {
//
//            float posX = motionEvent.getX();
//            float posY = motionEvent.getY();
//            pruebaCanvas.posCocheX = posX;
//            pruebaCanvas.posCocheY = posY; pruebaCanvas.invalidate(); return false;
//        });
//
//    }
//}