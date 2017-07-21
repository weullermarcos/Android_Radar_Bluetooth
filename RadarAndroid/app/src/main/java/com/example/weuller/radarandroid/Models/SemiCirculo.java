package com.example.weuller.radarandroid.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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

        float width = (float) getWidth();
        float height = (float) getHeight();
        float radius;

        if (width > height) {
            radius = height / 4;
        }
        else {
            radius = width / 4;
        }

        Path path = new Path();
        path.addCircle(width / 2, height / 2, radius, Path.Direction.CW);

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);

        center_x = width / 2;
        center_y = height / 2;

        oval.set(center_x - radius, center_y - radius, center_x + radius, center_y + radius);
        canvas.drawArc(oval, 180, 180, true, paint);

    }
}
