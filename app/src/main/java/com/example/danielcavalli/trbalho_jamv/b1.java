package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/**
 * CREATED BY
 * Alphabet Inc. | Headquartered in Mauntain View, California
 * IN A PARTNERSHIP WITH
 * Facebook Enterprises | Headquartered in Palo Alto, California
 * AND
 * Inc. Agency | Headquartered in Maricá, Rio de Janeiro
 * ON 22/07/2016.
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
        y=1080-h-(h/3);
        x = 3200 + rand.nextInt(1250);
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
