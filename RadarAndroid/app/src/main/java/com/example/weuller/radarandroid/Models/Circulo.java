package com.example.weuller.radarandroid.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by weuller on 21/07/2017.
 */

public class Circulo extends View {

    private Paint paint;

    public Circulo(Context context){
        this(context, null);
    }

    public Circulo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawCircle(400, 400, 150, paint);
    }
}
