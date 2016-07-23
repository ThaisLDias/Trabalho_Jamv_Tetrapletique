package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

/**
 * CREATED BY
 * Alphabet Inc. | Headquartered in Mauntain View, California
 * IN A PARTNERSHIP WITH
 * Facebook Enterprises | Headquartered in Palo Alto, California
 * AND
 * Inc. Agency | Headquartered in Maricá, Rio de Janeiro
 * ON 22/07/2016.
 */
public class GameView extends View implements Runnable{

    public Handler handler;
    public Player Jamv;
    public ArrayList<b1> pL;
    public ArrayList<b2> pL2;
    public static boolean movControl;
    public static int screenW, screenH;
    public boolean died1;
    public died morreu;
    public boolean co;
    int timer;
    public int score;
    public fundo f1;
    public fundo f2;

    public GameView (Context c)
    {
        super(c);

        screenW = c.getResources().getDisplayMetrics().widthPixels;
        screenH = c.getResources().getDisplayMetrics().heightPixels;
        morreu = new died(c);
        Jamv = new Player(50,50,c);
        int m =300;
        pL = new ArrayList<b1>();
        pL.add(new b1(c));
        pL.add(new b1(c));
        pL2 = new ArrayList<b2>();
        pL2.add(new b2(c));
        pL2.add(new b2(c));
        died1 = false;
        handler = new Handler();
        co = false;
        timer = 10;
        f1 = new fundo(c,0);
        f2 = new fundo(c,screenW);
        handler.post(this);
    }
    public boolean onTouchEvent(MotionEvent event)
    {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(!died1)
            {
                Jamv.changeGravity();
            }
            else
            {
                if(timer < 0)
                {
                    co = false;
                    timer = 10;
                    score = 0;
                    died1=false;
                }
            }
        }

        return true;
    }

    private void update()
    {
        Jamv.Update();
        for(b1 p : pL)
        {
            p.Update();
            if(Jamv.Col(p.x,p.y,p.w,p.h))
            {
                died1 = true;
                p.x = 5000;
            }
        }
        for(b2 p : pL2)
        {
            p.Update();
            if(Jamv.Col(p.x,p.y,p.w,p.h))
            {
                p.x = 5000;
                died1 = true;
            }
        }
        score += 3;
        f1.Update();
        f2.Update();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Paint p = new Paint();
        p.setTextSize(50f);
        super.onDraw(canvas);
        if(!died1)
        {
            f1.Draw(canvas);
            f2.Draw(canvas);
            pL.get(0).Draw(canvas);
            pL2.get(0).Draw(canvas);
            pL.get(1).Draw(canvas);
            pL2.get(1).Draw(canvas);
            Jamv.Draw(canvas);

            canvas.drawText("Pontos: " + (score/10) + "%", (canvas.getWidth() / 2), 50, p);
        }
        else
        {
            if(!co)
            {
                morreu.Update();
                co = true;
            }
            else{
            morreu.Draw(canvas);}
        }
    }

    @Override
    public void run(){

        handler.postDelayed(this, 30);

        if(!died1)
        {
            update();
        }
        else
        {
            timer--;
        }
        if(score > 1000)
        {
            MainActivity l = new MainActivity();
            l.gameOver();
        }
        invalidate();
    }
}

