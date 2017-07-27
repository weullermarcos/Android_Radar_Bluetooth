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
    private static final int INITIAL_ANGLE = 15;
    private static final int FINAL_ANGLE = 165;
    private static final int X_BACK_TEXT_CONSTANT = 25;
    private static final int Y_BACK_TEXT_CONSTANT = 5;
    private static final int DELAY = 30;

    private static final int ANGLE_30 = 30;
    private static final int ANGLE_60 = 60;
    private static final int ANGLE_90 = 90;
    private static final int ANGLE_120 = 120;
    private static final int ANGLE_150 = 150;
    private static final int ANGLE_180 = 180;

    private float startX = 0;
    private float startY = 0;
    private boolean incrementAngle = true;

    private int currentAngle = INITIAL_ANGLE;

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

        float center_x, center_y;
        //posiciona horizontalmente no centro da tela
        center_x = width / 2;
        startX = center_x;
        Log.d("center_x", String.valueOf(center_x));
        //posicionar no fundo da tela, um pouco a cima
        center_y = height / 2;
        startY = center_y;
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
        canvas.drawArc(oval, ANGLE_180, ANGLE_180, true, paint);

        //arco 2
        oval = new RectF();
        oval.set(center_x - radius2, center_y - radius2, center_x + radius2, center_y + radius2);
        canvas.drawArc(oval, ANGLE_180, ANGLE_180, true, paint);

        //arco 3
        oval = new RectF();
        oval.set(center_x - radius3, center_y - radius3, center_x + radius3, center_y + radius3);
        canvas.drawArc(oval, ANGLE_180, ANGLE_180, true, paint);

        //arco 4 (MENOR)
        oval = new RectF();
        oval.set(center_x - radius4, center_y - radius4, center_x + radius4, center_y + radius4);
        canvas.drawArc(oval, ANGLE_180, ANGLE_180, true, paint);

        //LINHA 0 graus
        canvas.drawLine(center_x, center_y, width, center_y, paint);

        //LINHA 30 graus
        float xFinal = center_x + catetoAdjacente(ANGLE_30, radius1);
        float yFinal = center_y - catetoOposto(ANGLE_30, radius1);
        canvas.drawLine(center_x, center_y, xFinal, yFinal, paint);

        // desenhando o texto de 30°
        canvas.save();
        canvas.rotate(65, (xFinal + 7), (yFinal - 17));
        canvas.drawText("30°", (xFinal + 7), (yFinal - 17), paintText);
        canvas.restore();

        //LINHA 60 graus
        xFinal = center_x + catetoAdjacente(ANGLE_60, radius1);
        yFinal = center_y - catetoOposto(ANGLE_60, radius1);
        canvas.drawLine(center_x, center_y, xFinal, yFinal, paint);

        // desenhando o texto de 60°
        canvas.save();
        canvas.rotate(35, (xFinal + 2), (yFinal - 15));
        canvas.drawText("60°", (xFinal + 2), (yFinal - 15), paintText);
        canvas.restore();

        //LINHA 90 graus
        canvas.drawLine(center_x, center_y, center_x, (center_y - radius1), paint);

        // desenhando o texto de 90°
        canvas.drawText("90°", (center_x - 10), (center_y - radius1 - 10), paintText);

        //LINHA 120 graus
        xFinal = center_x + catetoAdjacente(ANGLE_120, radius1);
        yFinal = center_y - catetoOposto(ANGLE_120, radius1);
        canvas.drawLine(center_x, center_y, xFinal, yFinal, paint);

        // desenhando o texto de 120°
        canvas.save();
        canvas.rotate(-30, (xFinal - 15), (yFinal - 5));
        canvas.drawText("120°", (xFinal - 15), (yFinal - 5), paintText);
        canvas.restore();

        //LINHA 150 graus
        xFinal = center_x + catetoAdjacente(ANGLE_150, radius1);
        yFinal = center_y - catetoOposto(ANGLE_150, radius1);
        canvas.drawLine(center_x, center_y, xFinal, yFinal, paint);

        // desenhando o texto de 150°
        canvas.save();
        canvas.rotate(-55, (xFinal - 10), (yFinal - 5));
        canvas.drawText("150°", (xFinal - 10), (yFinal - 5), paintText);
        canvas.restore();

        //desenhando distancias
        canvas.drawText("40 cm", (center_x + radius1 - X_BACK_TEXT_CONSTANT), (center_y - Y_BACK_TEXT_CONSTANT), paintText);
        canvas.drawText("30 cm", (center_x + radius2 - X_BACK_TEXT_CONSTANT), (center_y - Y_BACK_TEXT_CONSTANT), paintText);
        canvas.drawText("20 cm", (center_x + radius3 - X_BACK_TEXT_CONSTANT), (center_y - Y_BACK_TEXT_CONSTANT), paintText);
        canvas.drawText("10 cm", (center_x + radius4 - X_BACK_TEXT_CONSTANT), (center_y - Y_BACK_TEXT_CONSTANT), paintText);

        //Desenhando Agulha
        xFinal = center_x + catetoAdjacente(currentAngle, radius1);
        yFinal = center_y - catetoOposto(currentAngle, radius1);
        canvas.drawLine(startX, startY, xFinal, yFinal, paintLine);

        //lógica para controle de movimento da agulha
        if (currentAngle <= FINAL_ANGLE && incrementAngle) { // set end points

            currentAngle ++;
        }
        else if(currentAngle == INITIAL_ANGLE){
            incrementAngle = true;
            currentAngle ++;
        }
        else{
            incrementAngle = false;
            currentAngle --;
        }

        //delay de movimento da agulha
        postInvalidateDelayed(DELAY); // set time here
    }

    private Paint paint = new Paint() {
        {
            setColor(Color.GREEN);
            setStyle(Paint.Style.STROKE);
            setStrokeWidth(5);
            setAntiAlias(true);
        }
    };

    private Paint paintText = new Paint() {
        {
            setColor(Color.GREEN);
            setStyle(Paint.Style.STROKE);
            setStrokeWidth(2);
            setTextSize(20);
            setAntiAlias(true);
        }
    };

    private Paint paintLine = new Paint() {
        {
            setColor(Color.RED);
            setStrokeWidth(5);
            setStyle(Paint.Style.FILL);
            setStyle(Paint.Style.STROKE);
            setAntiAlias(true);
        }
    };

    //calcula o cateto oposto
    private float catetoOposto(int angle, float hipotenusa){

        //o angulo tem que estar em radianos
        double co = hipotenusa * Math.sin(Math.PI / 180 * angle);
        return (float) co;
    }

    //calcula o cateto oposto
    private float catetoAdjacente(int angle, float hipotenusa){

        //o angulo tem que estar em radianos
        double ca = hipotenusa * Math.cos(Math.PI/180*angle);
        return (float) ca;
    }

}
