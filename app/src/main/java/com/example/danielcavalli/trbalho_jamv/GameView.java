package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View implements Runnable{

    public Handler handler;
    public Player Jamv;
    public ArrayList<b1> pL;
    public ArrayList<b2> pL2;
    public static boolean movControl;
    public static int screenW, screenH;

    public GameView (Context c)
    {
        super(c);

        screenW = c.getResources().getDisplayMetrics().widthPixels;
        screenH = c.getResources().getDisplayMetrics().heightPixels;

        Jamv = new Player(50,50,c);
        int m =300;
        pL = new ArrayList<b1>();
        pL.add(new b1(c));
        pL.add(new b1(c));
        pL2 = new ArrayList<b2>();
        pL2.add(new b2(c));
        pL2.add(new b2(c));

        handler = new Handler();
        handler.post(this);
    }
    public boolean onTouchEvent(MotionEvent event)
    {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            Jamv.changeGravity();
        }
        return true;
    }

    private void update()
    {
        Jamv.Update();
        for(b1 p : pL)
        {
            p.Update();
        }
        for(b2 p : pL2)
        {
            p.Update();
        }
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //invalidate();
        super.onDraw(canvas);

        pL.get(0).Draw(canvas);
        pL2.get(0).Draw(canvas);
        pL.get(1).Draw(canvas);
        pL2.get(1).Draw(canvas);
        Jamv.Draw(canvas);
    }

    @Override
    public void run(){

        handler.postDelayed(this, 30);

        update();
        invalidate();
    }
}

