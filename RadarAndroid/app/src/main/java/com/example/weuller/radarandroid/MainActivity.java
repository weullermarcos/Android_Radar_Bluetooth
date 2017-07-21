package com.example.weuller.radarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.example.weuller.radarandroid.Models.Quadrado;

public class MainActivity extends AppCompatActivity {

    private Quadrado quadrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        quadrado =  new Quadrado(this);
//        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        quadrado.setLayoutParams(lp);
//
//        LinearLayout ll = (LinearLayout) findViewById(R.id.lltPrincipal);
//        ll.addView(quadrado);

    }
}
