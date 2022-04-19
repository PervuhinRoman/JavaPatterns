package com.company;

import java.util.*;

public class Generation {
    static Scanner in = new Scanner(System.in);

    private static String question = "";
    private static int rightAnswer;

    static int questionsCount;            // пользовательский ввод | кол-во выражений
    static int numbersCount;              // пользовательский ввод | кол-во чисел в выражении
    static final int numbersRange = 10;
    static final int answersCount = 3;    // пользовательский ввод | кол-во ответов
    static int answersRange;              // пользовательский ввод | диапазон ответов

    static ArrayList<String> alreadyGeneratedNumbers = new ArrayList<>(); // для генерации
    static ArrayList<Integer> alreadyGeneratedAnswers = new ArrayList<>(); // для генерации

    static String[] actions = {"+", "-"}; // для генерации
    static String prevAction;             // для генерации

    static ArrayList<String> itemAnswers = new ArrayList<>(answersCount);          // массив рандомных ответов

    static List<Integer> userAnswers = new ArrayList<>();              // массив пользовательских ответов
    static List<Integer> rightAnswers = new ArrayList<>();             // массив правильных ответов
    static List<String> expressions = new ArrayList<>();               // массив выражений

    // иммитация ввода пользователя
    public static void In(){
        System.out.println("SETTINGS");
        System.out.println("questionsCount: ");
        questionsCount = in.nextInt();
        System.out.println("NumbersCount: ");
        numbersCount = in.nextInt();
        System.out.println("Answers range: ");
        answersRange = in.nextInt();
        System.out.println();
    }

    // генерация чисел для выражения
    public static void numberGeneration(int  numbersCount, int numbersRange){
        String number = Integer.toString((int)(Math.random() * (numbersRange - 1) + 1));

        for(int i = 0; i < numbersCount; i++) {

            // проверка
            while (alreadyGeneratedNumbers.size() > 0 && alreadyGeneratedNumbers.contains(number)) {
                // генерация
                number = Integer.toString((int) (Math.random() * (numbersRange + 1) + 1));
            }
            alreadyGeneratedNumbers.add(number);
        }
    }

    // генерация действия
    public static String actionGeneration(String[] actions){
        String action = actions[(int) (Math.random() * 2)];

        while(action.equals(prevAction)) {
            action = actions[(int) (Math.random() * 2)];
        }

        prevAction = action;

        return action;
    }

    // генерация случайных ответов
    public static String answerGeneration(int rightAnswer, int answersRange){
        int number = (int)(Math.random() * (answersRange + 1) - (answersRange + 1));

        // проверка
        while(alreadyGeneratedAnswers.size() > 0 && (alreadyGeneratedAnswers.contains(number) || number == rightAnswer)){
            // генерация
            number = (int)(Math.random() * (answersRange + 1) - (answersRange + 1));
        }
        alreadyGeneratedAnswers.add(number);

        return Integer.toString(number);
    }

    static int cnt = 0;

    public static void mGen(){
        numberGeneration(numbersCount, numbersRange);
        String number;
        String action;

        // генерация первого числа
        number = alreadyGeneratedNumbers.get(0);
        question += number;

        // начинаем считать правильный ответ
        rightAnswer = Integer.parseInt(number);

        for(int i = 1; i < alreadyGeneratedNumbers.size(); i++){
            // генерируем действие и добавляем в выражение
            action = actionGeneration(actions);
            question += action;

            // генерация числа и добавление в выражение
            number = alreadyGeneratedNumbers.get(i);
            question += number;

            // считаем правильный ответ
            switch (action) {
                case "+" -> rightAnswer += Integer.parseInt(number);
                case "-" -> rightAnswer -= Integer.parseInt(number);
            }
        }

        // генерация случайных ответов
        int rightAnsInd = (int)(Math.random() * (answersCount) + 0);

        for(int i = 0; i < answersCount; i++){
            if(i == rightAnsInd){
                itemAnswers.add(Integer.toString(rightAnswer));
            } else {
                itemAnswers.add(answerGeneration(rightAnswer, answersRange));
            }
        }

        //System.out.println(itemAnswers);

        itemAnswers.clear();

        rightAnswers.add(rightAnswer);
        // обнуляем правильный ответ
        rightAnswer = 0;

        expressions.add(question);
        // обнуляем выражение
        question = "";

        // отчищаем массив рандомных ответов и т.д.

        alreadyGeneratedNumbers.clear();
        alreadyGeneratedAnswers.clear();
    }

    public static void main(String[] args) {
        In();
        for (int i = 0; i < questionsCount; i++){
            mGen();
        }
        int j = 0;
        for (int i = 0; i < questionsCount; i++){
            System.out.print("[" + expressions.get(i) + "] |");
            System.out.print(rightAnswers.get(i) + "|");
            System.out.println();
        }
    }
}
