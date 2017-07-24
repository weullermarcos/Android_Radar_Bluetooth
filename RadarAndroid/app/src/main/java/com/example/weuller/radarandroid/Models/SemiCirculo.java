package com.example.weuller.radarandroid.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by weuller on 21/07/2017.
 */

public class SemiCirculo extends View {

    public SemiCirculo(Context context){
        this(context, null);
    }

    public SemiCirculo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //pega a lagura da tela
        float width = (float) getWidth();

        //pega a altura da tela
        float height = (float) getHeight();

        //raio do circulo
        float radius = (width/2);

        Log.d("width", String.valueOf(width));
        Log.d("RAIO", String.valueOf(radius));

        Path path = new Path();
        path.addCircle(width / 2, height / 2, radius, Path.Direction.CW);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);

        //posiciona horizontalmente no centro da tela
        center_x = width / 2;

        //posicionar no fundo da tela, um pouco a cima
        center_y = height;

        oval.set(center_x - radius, center_y - radius, center_x + radius, center_y + radius);
        canvas.drawArc(oval, 180, 180, true, paint);

    }
}
