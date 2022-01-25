# Решение практической работы 3.4.1

Разработать пример программы, совершающей загрузку картинки из интернета и устанавливающей
ее на экран.
Картинку из интернета можно загрузить по ссылке.

## О коде:
* Поток создан с помощью интерфеса `Runnable`
* Для обращения к UI использован класс `Handler`
```java
Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override public void run() {
                    image.setImageBitmap(bitmap);
                }
            });
 ```
 * Или более понятный способ через метод `post` класса `View`:
 ```java
 image.post(new Runnable() {
     @Override
     public void run() {
         image.setImageBitmap(bitmap);
     }
 });
 ```

## Полезные ссылки:
* [Откуда узнал про Handler](https://android-tools.ru/coding/zamena-asynctask-v-prilozhenii/)
* [Как применять Handler](https://itsobes.ru/AndroidSobes/chto-takoe-handler/)
* [Что такое Looper](https://itsobes.ru/AndroidSobes/chto-takoe-looper/)
* [Ещё про Handler](http://developer.alexanderklimov.ru/android/theory/handler.php)
* [Официальная инфа про Handler](https://developer.android.com/reference/android/os/Handler)
