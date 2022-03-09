package com.company;

import java.util.*;

public class Generation {

    static ArrayList<Integer> alreadyGeneratedNumbers = new ArrayList<>();
    static ArrayList<Integer> alreadyGeneratedAnswers = new ArrayList<>();

    static String[] actions = {"+", "-"};
    static String prevAction;

    // генерация чисел для выражения
    public static String generation(int range){
        int number = (int)(Math.random() * (range + 1) + 1);

        // сортировка
        Collections.sort(alreadyGeneratedNumbers);

        // проверка
        while(alreadyGeneratedNumbers.size() > 0 && alreadyGeneratedNumbers.contains(number)){
            // генерация
            number = (int)(Math.random() * (range + 1) + 1);
        }
        alreadyGeneratedNumbers.add(number);

        return Integer.toString(number);
    }

    // генерация действия
    public static String generation(String[] actions){
        String action = actions[(int) (Math.random() * 2)];

        while(action.equals(prevAction)) {
            action = actions[(int) (Math.random() * 2)];
        }

        prevAction = action;

        return action;
    }

    // генерация случайных ответов
    public static String generation(int rightAnswer, int range){
        int number = (int)(Math.random() * (range + 1) - (range + 1));

        // проверка
        while(alreadyGeneratedAnswers.size() > 0 && (alreadyGeneratedAnswers.contains(number) || number == rightAnswer)){
            // генерация
            number = (int)(Math.random() * (range + 1) - (range + 1));
        }
        alreadyGeneratedAnswers.add(number);

        return Integer.toString(number);
    }

    public static ArrayList<String> question(int numbersCount){
        ArrayList<String> out = new ArrayList<>();
        String number;
        String action;
        StringBuilder expression = new StringBuilder();
        int rightAnswer = 0; // верный ответ, который вычисляет компьютер

        // генерируем число
        number = generation(10);
        expression.append(number);
        rightAnswer += Integer.parseInt(number);

        for(int i = 0; i < numbersCount - 1; i++){
            // генерируем действие
            action = generation(actions);
            // генерируем число
            number = generation(10);

            switch (action) {
                case "+" :
                    rightAnswer += Integer.parseInt(number);
                    break;
                case "-" :
                    rightAnswer -= Integer.parseInt(number);
                    break;
            }
            expression.append(" ").append(action).append(" ").append(number);
        }

        out.add(expression.toString());
        out.add(Integer.toString(rightAnswer));
        return out;
    }

    public static ArrayList<String> answers(int answersCount, int rightAnswer, int range){
        ArrayList<String> out = new ArrayList<>();
        for(int i = 0; i < answersCount - 1; i++){
            out.add(generation(rightAnswer, range));
        }

        out.add((int)(Math.random()*out.size()), Integer.toString(rightAnswer));

        return out;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> question;

        int numbersCount;
        int answersCount;
        int range;
        System.out.println("SETTINGS");
        System.out.println("NumbersCount: ");
        numbersCount = in.nextInt();
        System.out.println("AnswersCount: ");
        answersCount = in.nextInt();
        System.out.println("Range: ");
        range = in.nextInt();
        System.out.println();

        question = question(numbersCount);
        System.out.println(question);
        System.out.println(answers(answersCount, Integer.parseInt(question.get(1)), range));
    }
}
