package com.example.currentapp;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class MyDraw extends View {
        public MyDraw (Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);

            Bitmap image = pc;
            int xx = canvas.getWidth(), yy = canvas.getHeight();
            canvas.drawBitmap(image, xx - image.getWidth(), yy - image.getHeight(), paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyDraw(this));
        //setContentView(R.layout.activity_main);
        Thread thread = new Thread(new ThreadForDownload());
        thread.start();
    }

    public  Bitmap pc;

    class ThreadForDownload implements Runnable {

        @Override
        public void run() {
            try {
                URL url = new URL("https://static.ngs.ru/news/2015/99/preview/0ff14d20c62e08b3ef8741d35793524b0d3d50a8_599_399_c.jpg");
                pc = BitmapFactory.decodeStream((InputStream) url.getContent());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
// https://static.ngs.ru/news/2015/99/preview/0ff14d20c62e08b3ef8741d35793524b0d3d50a8_599_399_c.jpg
