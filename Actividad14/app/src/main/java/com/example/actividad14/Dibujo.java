package com.example.actividad14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;



public class Dibujo extends View {

    Paint paint;

    public Dibujo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        canvas.drawLine(100, 100, 600, 800, paint);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(600, 1000, 100, paint);

    }
}
