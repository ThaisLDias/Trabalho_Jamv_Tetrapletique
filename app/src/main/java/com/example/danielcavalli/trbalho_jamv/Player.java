package com.example.danielcavalli.trbalho_jamv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * CREATED BY
 * Alphabet Inc. | Headquartered in Mauntain View, California
 * IN A PARTNERSHIP WITH
 * Facebook Enterprises | Headquartered in Palo Alto, California
 * AND
 * Inc. Agency | Headquartered in Maricá, Rio de Janeiro
 * ON 22/07/2016.
 */
public class Player
{
    public int x;
    public int y;
    public int w = 146;
    public int h = 230;
    public float g = 50;
    public float temp = 0;
    public Paint color;
    public Context ctx;
    private Bitmap b;

    public Player(int x2, int y2,Context c)
    {
        x = x2;
        y = y2;
        ctx = c;
        color = new Paint();
        color.setColor(Color.WHITE);
        b = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.dezessete);
        b = getResizedBitmap(b,h,w);
    }
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }
    public void Draw(Canvas canvas)
    {
        canvas.drawBitmap(b, x, y, color);
    }
    public void changeGravity()
    {
        g *= -1;
    }
    boolean Col(int x1,int y1,int w1, int h1)
    {
        return ((x + w >= x1) && (y + h >= y1) && x <= x1 + w1 && y <= y1 + h1);
    }

    public void Update()
    {
        int cH = GameView.screenH;
        y -= g;
        if(y < 0)
        {
            y +=g;
            y = 0;
        }
        if(y > cH-h-(h/3)+12)
        {
            y -=g;
            y = cH-h-(h/3)+12;
        }
    }
}

