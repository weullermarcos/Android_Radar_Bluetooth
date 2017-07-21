package com.example.weuller.radarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.example.weuller.radarandroid.Models.Circulo;
import com.example.weuller.radarandroid.Models.Quadrado;
import com.example.weuller.radarandroid.Models.SemiCirculo;

public class MainActivity extends AppCompatActivity {

    private Quadrado quadrado;
    private Circulo circulo;
    private SemiCirculo semiCirculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        LinearLayout ll = (LinearLayout) findViewById(R.id.lltPrincipal);

//        quadrado =  new Quadrado(this);
//        quadrado.setLayoutParams(lp);
//        ll.addView(quadrado);

//        circulo = new Circulo(this);
//        circulo.setLayoutParams(lp);
//        ll.addView(circulo);

        semiCirculo = new SemiCirculo(this);
        semiCirculo.setLayoutParams(lp);
        ll.addView(semiCirculo);

    }
}
