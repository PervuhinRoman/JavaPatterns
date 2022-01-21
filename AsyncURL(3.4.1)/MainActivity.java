/**
 * У меня создан поток, для звгрузки изображения, об успешном завершении данной задачи я узнаю из Log.d (отладочного вывода)
 * но добавить картинку в/на activity могу только после нажатия на конпку "обновить"
 * как сделать, чтобы после успешной загрузки картинки она сама добавлялась в/на активность?
 *
 * есть ли разница в реализации обработки нажатия кнопок: а) через android:onClick="<ИМЯ_ФУНКЦИИ>"
 *                                                        б) через setOnClickListener(...)        ?
 **/

package com.example.asyncapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "ALL";

    String status = "";

    Bitmap bitmap;
    TextView txt;
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
        txt = findViewById(R.id.textView);

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
                status = "Изображение получено";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d(LOG_TAG,"Изображение получено");
        }
    }

    // обновление состояния активити
    public void refresh(View view){
        txt.setText(status);
        image.setImageBitmap(bitmap);
    }
}
