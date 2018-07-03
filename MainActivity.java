package com.example.yuka.targetsexercise;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startMoving(View view) {
        final BouncingBall cv = findViewById(R.id.bounce_ball);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        // 1000 msec : 1 sec
                        // 50 msec : 0.02 sec (50 fps)
                        Thread.sleep(50);
                        cv.postInvalidate(); // redraw the view (call onDraw!)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        thread.start();

    }
}
