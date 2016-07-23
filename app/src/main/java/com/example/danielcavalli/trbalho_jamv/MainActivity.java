package com.example.danielcavalli.trbalho_jamv;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import static java.lang.Math.round;
import android.content.Intent;


public class MainActivity extends AppCompatActivity{

    long lastUpdate = 0;
    public static float y ;
    public static float x ;
    public static float z;
    public GameView gameviewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameviewer = new GameView(this);
        setContentView(gameviewer);

    }

    public void gameOver()
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction("JAMV");
        sendIntent.putExtra("letter","E2");
        startActivity(sendIntent);
    }


}
