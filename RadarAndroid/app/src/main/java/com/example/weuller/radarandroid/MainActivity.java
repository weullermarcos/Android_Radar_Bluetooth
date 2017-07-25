package com.example.weuller.radarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.example.weuller.radarandroid.Models.Radar;

public class MainActivity extends AppCompatActivity {

    private Radar radar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        LinearLayout ll = (LinearLayout) findViewById(R.id.lltPrincipal);

        radar = new Radar(this);
        radar.setLayoutParams(lp);
        ll.addView(radar);

    }
}
