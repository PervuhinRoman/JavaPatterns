package com.example.asyncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "ALL";

    Bitmap bitmap;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // создание активности
        Log.d(LOG_TAG, "Создаётся активость");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Активость создалась");

        // иницилизация элементов
        image = findViewById(R.id.imageView);

        // запуск потока
        Thread thread = new Thread(new ThreadForDownload());
        thread.start();
        Log.d(LOG_TAG, "Поток запущен");
    }

    // описание потока
    class ThreadForDownload implements Runnable {
        @Override
        public void run() {
            try {
                URL url = new URL("https://static.ngs.ru/news/2015/99/preview/0ff14d20c62e08b3ef8741d35793524b0d3d50a8_599_399_c.jpg");
                bitmap = BitmapFactory.decodeStream((InputStream) url.getContent());
                Log.d(LOG_TAG,"Изображение получено");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.d(LOG_TAG,"Ошибка! Изображение не получено");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(LOG_TAG,"Ошибка! Изображение не получено");
            }

            // Класс handler позволяет отправлять сообщения в другие потоки, включая главный UI поток
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override public void run() {
                    image.setImageBitmap(bitmap);
                }
            });

            Log.d(LOG_TAG,"Поток завершён");
        }
    }
}
