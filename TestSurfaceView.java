package com.example.surfaceapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    public class DrawThread extends Thread {

        private volatile boolean running = true;

        private SurfaceHolder surfaceHolder;
        private Paint backgroundPaint = new Paint();
        private Paint circlePaint = new Paint();
        private int towardPointX;
        private int towardPointY;

        {
            backgroundPaint.setColor(Color.BLUE);
            circlePaint.setColor(Color.YELLOW);
        }

        public void setTowardPoint(int x, int y) {
            towardPointX = x;
            towardPointY = y;
        }

        public DrawThread(Context context, SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

        public void requestStop() {
            running = false;
        }
        private int radius = 0;
        public void setRadius(int rad){
            radius = rad;
        }

        @Override
        public void run() {
            while (running) {
                Canvas canvas = surfaceHolder.lockCanvas();
                if (canvas != null) {
                    try {


                        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                        canvas.drawCircle(towardPointX, towardPointY, radius, circlePaint);
                        radius+=5;
                        DrawThread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }

    private DrawThread drawThread;

    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new DrawThread(getContext(), getHolder());
        drawThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                //
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setTowardPoint((int)event.getX(),(int)event.getY());
        drawThread.setRadius(0);
        return false;
    }
}


