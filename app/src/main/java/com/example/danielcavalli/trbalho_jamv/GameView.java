package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;


import java.util.ArrayList;

public class GameView extends View implements Runnable{

    public Handler handler;
    public Player Jamv;
    public ArrayList<b1> pL;
    public ArrayList<b2> pL2;
    public static boolean movControl;
    public static int screenW, screenH;
    public static  int score;

    public GameView (Context c)
    {
        super(c);

        screenW = c.getResources().getDisplayMetrics().widthPixels;
        screenH = c.getResources().getDisplayMetrics().heightPixels;

        //score = 0;

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
            if(Jamv.Collision(p.x,p.y,p.w,p.h))
            {
                //player morre ai já nsei o que rola
            }
        }
        for(b2 p : pL2)
        {
            p.Update();
            if(Jamv.Collision(p.x,p.y,p.w,p.h))
            {
                //player morre ai já nsei o que rola
            }
        }
        Log.d("MainActivity",Float.toString(score));

        score += 1;
        if(score > 1000){
            MainActivity l = new MainActivity();
            l.gameOver();
        }
        Log.e("MainActivity",Float.toString(score));
    }



    @Override
    protected void onDraw(Canvas canvas)
    {
        //invalidate();
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setTextSize(50f);


        pL.get(0).Draw(canvas);
        pL2.get(0).Draw(canvas);
        pL.get(1).Draw(canvas);
        pL2.get(1).Draw(canvas);
        Jamv.Draw(canvas);

        canvas.drawText("Pontos: " + (score/10), (canvas.getWidth() / 2), 50, p);



    }

    @Override
    public void run(){

        handler.postDelayed(this, 30);

        update();
        invalidate();
    }
}

