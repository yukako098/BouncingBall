package com.example.yuka.targetsexercise;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BouncingBall extends View{

    private static final float SIZE = 25;
    private float ballX = 30;
    private float ballY = 30;
    private float velocityX = 10;
    private float velocityY = 10;

    public BouncingBall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw a red ball
        Paint red = new Paint();
        red.setARGB(255, 255, 0, 0);
        red.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(ballX, ballY, SIZE, red);

        ballX += velocityX;
        ballY += velocityY;

        float width = canvas.getWidth();
        float height = canvas.getHeight();

        if (ballX + SIZE >= width || ballX <= 0 + SIZE) {
            velocityX = -velocityX;
        }
        if (ballY + SIZE <= 0 || ballY >= height - SIZE) {
            velocityY = -velocityY;
        }


    }
}
