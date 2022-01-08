package com.example.birds;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    class Timer extends CountDownTimer {
        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            update();
        }

        @Override
        public void onFinish() {
        }
    }

    private int viewWidth;
    private int viewHeight;
    private int points = 0;

    private final int timerInterval = 30;


    private Sprite playerBird;
    private Sprite enemyBird;

    public GameView(Context context) {
        super(context);

        //angry birds

        Bitmap b1 = BitmapFactory.decodeResource(getResources(), R.drawable.enemy);
        int w1 = b1.getWidth()/5;
        int h1 = b1.getHeight()/3;

        Rect firstFrame1 = new Rect(4*w1, 0, 5*w1, h1);

        enemyBird = new Sprite(2000, 250, -1000, 0, firstFrame1, b1);

        for (int i = 0; i < 3; i++) {
            for (int j = 4; j >= 0; j--) {
                if (i ==0 && j == 4) {
                    continue;
                }
                if (i ==2 && j == 0) {
                    continue;
                }
                enemyBird.addFrame(new Rect(j*w1, i*h1, j*w1+w1, i*w1+w1));
            }
        }

        // king bird
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.player);

        int w = b.getWidth()/5;
        int h = b.getHeight()/3;

        Rect firstFrame = new Rect(0, 0, w, h);

        playerBird = new Sprite(10, 0, 0, 100, firstFrame, b);

        Timer t = new Timer();
        t.start();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 2 && j == 3) {
                    continue;
                }
                playerBird.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawARGB(250, 127, 199, 255); // заливаем цветом
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setTextSize(55.0f);
        p.setColor(Color.WHITE);
        canvas.drawText(points+"", viewWidth - 100, 70, p);
        //canvas.drawARGB(250, 127, 199, 255); // цвет фона
        playerBird.draw(canvas);

        enemyBird.draw(canvas);
        enemyBird.update(timerInterval);
    }

    protected void update () {
        playerBird.update(timerInterval);
        invalidate();

        if (playerBird.getY() + playerBird.getFrameHeight() > viewHeight) {
            playerBird.setY(viewHeight - playerBird.getFrameHeight());
            playerBird.setVy(-playerBird.getVy());
            points--;
        }
        else if (playerBird.getY() < 0) {
            playerBird.setY(0);
            playerBird.setVy(-playerBird.getVy());
            points--;
        }

        if (enemyBird.getX() < - enemyBird.getFrameWidth()) {
            teleportEnemy ();
            points +=10;
        }

        if (enemyBird.intersect(playerBird)) {
            teleportEnemy ();
            points -= 40;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int eventAction = event.getAction();

        if (eventAction == MotionEvent.ACTION_DOWN)  {
            // Движение вверх
            if (event.getY() < playerBird.getBoundingBoxRect().top) {
                playerBird.setVy(-700);
                points--;
            }
            else if (event.getY() > (playerBird.getBoundingBoxRect().bottom)) {
                playerBird.setVy(700);
                points--;
            }
        }
        return true;
    }

    private void teleportEnemy() {
        enemyBird.setX(viewWidth + Math.random() * 500);
        enemyBird.setY(Math.random() * (viewHeight - enemyBird.getFrameHeight()));
    }
}
