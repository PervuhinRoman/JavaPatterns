package com.company;

import java.util.Scanner;

public class Main {

    public static int numerator(String fraction){
        String subStr [] = fraction.split("/", 2);
        int wholePart = Integer.parseInt(subStr[0]);
        return wholePart;
    }

    public static int denominator(String fraction){
        String subStr [] = fraction.split("/", 2);
        int fractionalPart = Integer.parseInt(subStr[1]);
        return fractionalPart;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println();
            System.out.println("Enter the fraction: ");

            String frac1 = in.nextLine();
            Fraction fraction1 = new Fraction(numerator(frac1), denominator(frac1));

            String action = in.nextLine();

            String frac2 = in.nextLine();
            Fraction fraction2 = new Fraction(numerator(frac2), denominator(frac2));

            switch (action){
                case "+":
                    Fraction newFrac0 = new Fraction(1, 1).SumFractions(fraction1, fraction2);
                    System.out.println(newFrac0.Print());
                    break;
                case "-":
                    Fraction newFrac1 = new Fraction(1, 1).DifferenceFractions(fraction1, fraction2);
                    System.out.println(newFrac1.Print());
                    break;
                case ":":
                    Fraction newFrac2 = new Fraction(1, 1).QuotientFractions(fraction1, fraction2);
                    System.out.println(newFrac2.Print());
                    break;
                case "*":
                    Fraction newFrac3 = new Fraction(1, 1).ProductFractions(fraction1, fraction2);
                    System.out.println(newFrac3.Print());
                    break;
            }
        }
    }
}
