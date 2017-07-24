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

    private static final int MARGIN = 20;

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
        float width = (float) getWidth() - MARGIN;
        Log.d("WIDTH", String.valueOf(width));
        float distanceBetweenPoints = (float) width/8;
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
        //posicionar no fundo da tela, um pouco a cima
        center_y = height;

        //raios dos circulos
        float radius1 = (width/2);
        float radius2 = radius1 - distanceBetweenPoints;
        float radius3 = radius2 - distanceBetweenPoints;
        float radius4 = radius3 - distanceBetweenPoints;
        Log.d("RAIO1", String.valueOf(radius1));
        Log.d("RAIO2", String.valueOf(radius2));
        Log.d("RAIO3", String.valueOf(radius3));
        Log.d("RAIO4", String.valueOf(radius4));

//        Path path1 = new Path();
//        path1.addCircle(width / 2, height / 2, radius1, Path.Direction.CW);
//        Path path2 = new Path();
//        path2.addCircle(width / 2, height / 2, radius2, Path.Direction.CW);


        final RectF oval1 = new RectF();
        oval1.set(center_x - radius1, center_y - radius1, center_x + radius1, center_y + radius1);
        canvas.drawArc(oval1, 180, 180, true, paint);

        final RectF oval2 = new RectF();
        oval2.set(center_x - radius2, center_y - radius2, center_x + radius2, center_y + radius2);
        canvas.drawArc(oval2, 180, 180, true, paint);

        final RectF oval3 = new RectF();
        oval3.set(center_x - radius3, center_y - radius3, center_x + radius3, center_y + radius3);
        canvas.drawArc(oval3, 180, 180, true, paint);

        final RectF oval4 = new RectF();
        oval4.set(center_x - radius4, center_y - radius4, center_x + radius4, center_y + radius4);
        canvas.drawArc(oval4, 180, 180, true, paint);

    }

}
