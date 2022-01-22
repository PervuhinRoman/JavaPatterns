# Решение практической работы 3.4.1

## Формулировка задания:
Разработать пример программы, совершающей загрузку картинки из интернета и устанавливающей
ее на экран.
Картинку из интернета можно загрузить по ссылке.

## Полезное
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
