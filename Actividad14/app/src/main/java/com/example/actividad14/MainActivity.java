package com.example.actividad14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    PruebaCanvas pruebaCanvas;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba_canvas);
        pruebaCanvas = (PruebaCanvas)findViewById(R.id.canvasPrueba);

        pruebaCanvas.setOnTouchListener((view, motionEvent) -> {

            float posX = motionEvent.getX();
            float posY = motionEvent.getY();
            pruebaCanvas.posxInicio = posX;
            pruebaCanvas.posyInicio = posY;
            pruebaCanvas.invalidate();
            float posX2 = motionEvent.getX();
            float posy2 = motionEvent.getY();
            pruebaCanvas.posxFinal = posX2;
            pruebaCanvas.posyFinal = posy2;
            pruebaCanvas.invalidate();
            return false;
        });
    }
}