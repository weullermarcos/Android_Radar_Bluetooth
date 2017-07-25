package com.example.weuller.radarandroid.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by weuller on 21/07/2017.
 */

public class Radar extends View {

    private static final int HORIZONTAL_MARGIN = 120;

    public Radar(Context context){
        this(context, null);
    }

    public Radar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //pega a lagura da tela
        float width = (float) getWidth();
        float widthWithMargin = width - HORIZONTAL_MARGIN;
        Log.d("WIDTH", String.valueOf(widthWithMargin));
        float distanceBetweenPoints = (float) widthWithMargin/8;
        Log.d("DISTANCE", String.valueOf(distanceBetweenPoints));

        //pega a altura da tela
        float height = (float) getHeight();
        Log.d("HEIGHT", String.valueOf(height));

        //Paint
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.STROKE);

        float center_x, center_y;
        //posiciona horizontalmente no centro da tela
        center_x = width / 2;
        Log.d("center_x", String.valueOf(center_x));
        //posicionar no fundo da tela, um pouco a cima
        center_y = height / 2;
        Log.d("center_y", String.valueOf(center_y));


        //raios dos circulos
        float radius1 = (widthWithMargin/2);
        float radius2 = radius1 - distanceBetweenPoints;
        float radius3 = radius2 - distanceBetweenPoints;
        float radius4 = radius3 - distanceBetweenPoints;

        Log.d("RAIO1", String.valueOf(radius1));
        Log.d("RAIO2", String.valueOf(radius2));
        Log.d("RAIO3", String.valueOf(radius3));
        Log.d("RAIO4", String.valueOf(radius4));

        //arco 1 (MAIOR)
        RectF oval = new RectF();
        oval.set(center_x - radius1, center_y - radius1, center_x + radius1, center_y + radius1);
        canvas.drawArc(oval, 180, 180, true, paint);

        //arco 2
        oval = new RectF();
        oval.set(center_x - radius2, center_y - radius2, center_x + radius2, center_y + radius2);
        canvas.drawArc(oval, 180, 180, true, paint);

        //arco 3
        oval = new RectF();
        oval.set(center_x - radius3, center_y - radius3, center_x + radius3, center_y + radius3);
        canvas.drawArc(oval, 180, 180, true, paint);

        //arco 4 (MENOR)
        oval = new RectF();
        oval.set(center_x - radius4, center_y - radius4, center_x + radius4, center_y + radius4);
        canvas.drawArc(oval, 180, 180, true, paint);

        //LINHA INFERIOR
        canvas.drawLine(center_x, center_y, width, center_y, paint);

    }

}
