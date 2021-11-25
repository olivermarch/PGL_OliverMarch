package com.example.actividad14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PruebaCanvas extends View {
    float posxInicio = -1;
    float posyInicio = -1;
    float posxFinal;
    float posyFinal;

    Paint pincelAzul;
    Paint pincelVerde;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(posxInicio, posyInicio, posxFinal, posyFinal, pincelVerde);
        i

    }
    public PruebaCanvas(Context context) {
        super(context);
        init(); }
    public PruebaCanvas(Context context, AttributeSet attrs) { super(context, attrs);
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

