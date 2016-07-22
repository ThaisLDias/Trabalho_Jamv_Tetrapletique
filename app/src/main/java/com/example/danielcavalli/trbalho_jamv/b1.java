package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Alphabet Inc. | Headquartered in Mauntain View | on 22/07/2016.
 */
public class b1
{
    public int x;
    public int y;
    public int w = 305;
    public int h = 211;
    public float g = 50;
    public Paint color;
    public Context ctx;
    Random rand = new Random();
    int cW;
    Bitmap b;

    public b1(Context c)
    {
        y=1080-h;
        x = 1920 + rand.nextInt(1250);
        ctx = c;
        color = new Paint();
        color.setColor(Color.WHITE);
        b = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.a2);
    }
    public void Draw(Canvas canvas)
    {
        canvas.drawBitmap(b, x, y, color);
    }
    public void Update()
    {
        x -= g;
        if(x < -250)
        {
            x = GameView.screenW + rand.nextInt(1250);
        }
    }
}
