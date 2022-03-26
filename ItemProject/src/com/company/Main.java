package com.company;

import java.util.*;

interface Runnable{
    public void run();
}

class MyClass{
    static int count;
    void f(){
        count++;
        System.out.print(count + " ");
    }
}

class A {
    static {
        System.out.println("Hello world!");
    }

    public static int a;
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;
        int itemCnt = 1;
        int item1;
        int item2;
        int last = 0;
        int n = in.nextInt();
        ArrayList <Integer> array = new ArrayList<>();
        for(int i = 0; i < n; i++){
            array.add(in.nextInt());
        }

        /*for(int i = array.size() - 1; i >= 0; i--){
            System.out.println(array.size());
            System.out.println("i: " + i);
            item1 = array.get(i);

            for(int j = i - 1; j >= 0; j--){
                item2 = array.get(j);
                if(item2 == item1){
                    itemCnt++;
                    last = j;
                } else {
                    break;
                }
            }

            System.out.println(i + "-" + last + " : " + itemCnt);

            if(itemCnt >= 3){
                count += itemCnt;
                for(int r = 0; r < itemCnt; r++){
                    array.remove(last);
                }
            }

            itemCnt = 1;

            if(array.size() == 0)
                break;

            System.out.println(array + " " + array.size());
        }*/


        for(int i = 0; i < array.size(); i++){
            System.out.println(array.size());
            System.out.println("i: " + i);
            item1 = array.get(i);

            for(int j = i + 1; j < array.size(); j++){
                item2 = array.get(j);
                if(item2 == item1){
                    itemCnt++;
                    last = j;
                } else {
                    break;
                }
            }

            System.out.println(i + "-" + last + " : " + itemCnt);

            if(itemCnt >= 3){
                count += itemCnt;
                for(int r = 0; r < itemCnt; r++){
                    array.remove(i);
                }
            }

            itemCnt = 1;

            if(array.size() == 0)
                break;

            System.out.println(array + " " + array.size());
        }

        System.out.println(count);
    }
}
