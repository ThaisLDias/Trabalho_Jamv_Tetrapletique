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
 * CREATED BY
 * Alphabet Inc. | Headquartered in Mauntain View, California
 * IN A PARTNERSHIP WITH
 * Facebook Enterprises | Headquartered in Palo Alto, California
 * AND
 * Inc. Agency | Headquartered in Maricá, Rio de Janeiro
 * ON 22/07/2016.
 */
public class died
{
    public int x;
    public int y;
    public Paint color;
    public Context ctx;
    Random rand = new Random();
    int cW;
    Bitmap g1;
    Bitmap g2;
    Bitmap g3;
    Bitmap g4;
    Bitmap g5;
    Bitmap bitfinal;

    public died(Context c)
    {
        y=0;
        x=0;
        ctx=c;
        color=new Paint();
        color.setColor(Color.WHITE);
        g1 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.g1);
        g2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.g2);
        g3 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.g3);
        g4 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.g4);
        g5 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.g5);
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
        canvas.drawBitmap(bitfinal, x, y, color);
    }
    public void Update()
    {
        int a = rand.nextInt(6);
        if(a == 1)
        {
            bitfinal = getResizedBitmap(g1,GameView.screenH,GameView.screenW);;
        }
        if(a == 2)
        {
            bitfinal = getResizedBitmap(g2,GameView.screenH,GameView.screenW);
        }
        if(a == 3)
        {
            bitfinal = getResizedBitmap(g3,GameView.screenH,GameView.screenW);
        }
        if(a == 4)
        {
            bitfinal = getResizedBitmap(g4,GameView.screenH,GameView.screenW);
        }
        if(a == 5)
        {
            bitfinal = getResizedBitmap(g5,GameView.screenH,GameView.screenW);
        }
    }
}
