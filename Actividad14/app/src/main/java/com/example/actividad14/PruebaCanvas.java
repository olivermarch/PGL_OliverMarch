package com.example.actividad14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PruebaCanvas extends View {
    float posCocheX = -1;
    float posCocheY = -1;
    Paint pincelAzul;
    Paint pincelVerde;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int ancho = canvas.getWidth();
        int largo = canvas.getHeight();
        canvas.drawRect(0,0, ancho,largo,pincelAzul);
        if(posCocheX != -1 || posCocheY != -1){
            canvas.drawCircle( posCocheX, posCocheY, 20,pincelVerde);
        }
    }
    public PruebaCanvas(Context context) {
        super(context);
        init(); }
    public PruebaCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public PruebaCanvas(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(); }
    public PruebaCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(); }
    private void init(){
        pincelAzul = new Paint();
        pincelAzul.setColor(Color.BLUE);
        pincelAzul.setStrokeWidth(15);
        pincelVerde = new Paint();
        pincelVerde.setColor(Color.GREEN);
        pincelVerde.setStrokeWidth(7);
        pincelVerde.setStyle(Paint.Style.STROKE);
    } }

