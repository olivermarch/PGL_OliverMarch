package com.example.actividad14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;



public class Dibujo extends View {

    float posX = -1;
    float posY = -1;
    Paint paint;

    public Dibujo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();
        paint.setStrokeWidth(10);

        if(posX != -1 || posY != -1){
            //canvas.drawCircle( posX, posY, 20,paint);
            paint.setColor(Color.RED);
            canvas.drawLine(posX, posY, posX, posY, paint);
        }
//        paint.setColor(Color.RED);
//        canvas.drawLine(posX, posY, posX, posY, paint);

//        paint.setColor(Color.GREEN);
//        canvas.drawCircle(posX, posY, 50, paint);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        posX = event.getX();
        posY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }
        return super.onTouchEvent(event);

    }
}
