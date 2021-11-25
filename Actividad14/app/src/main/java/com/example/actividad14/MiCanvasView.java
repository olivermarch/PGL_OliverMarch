package com.example.actividad14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MiCanvasView extends View {
    Paint paint;

    public MiCanvasView(Context context, AttributeSet attrs) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint = new Paint(); //paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        int ancho = canvas.getWidth();
        canvas.drawRect(10,70,ancho - 10, 20, paint); }
}
