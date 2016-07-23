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
public class fundo
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

    public fundo(Context c, int x1)
    {
        y=0;
        x=x1;
        ctx=c;
        color=new Paint();
        color.setColor(Color.WHITE);
        g1 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.fundo);
        g1 = getResizedBitmap(g1,GameView.screenH,GameView.screenW);;
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
        canvas.drawBitmap(g1, x, y, color);
    }
    public void Update()
    {
        x -= 1;
        if(x <= -GameView.screenW)
        {
            x = GameView.screenW;
        }
    }
}
