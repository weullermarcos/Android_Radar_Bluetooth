package com.example.weuller.radarandroid.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class Quadrado extends View {
    private Paint paint;
    private Rect retangulo;


    public Quadrado(Context context){
        this(context, null);
    }
    public Quadrado(Context context, AttributeSet attrs){
        super(context, attrs);

        paint = new Paint();
        paint.setARGB(255, 255, 0, 0);
        retangulo = new Rect(0, 0, 300, 300);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(retangulo, paint);
    }
}
