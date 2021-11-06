package com.company;

import java.util.Scanner;

public class Main {

    public static int Numerator(String fraction){
        String subStr [] = fraction.split("/", 2);
        int wholePart = Integer.parseInt(subStr[0]);
        return wholePart;
    }

    public static int Denominator(String fraction){
        String subStr [] = fraction.split("/", 2);
        int fractionalPart = Integer.parseInt(subStr[1]);
        return fractionalPart;
    }

    public static void MainVariant1(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first fraction: ");
        String frac1 = in.nextLine();
        Fraction fraction1 = new Fraction(Numerator(frac1), Denominator(frac1));

        System.out.print("Enter the action: ");
        String action = in.nextLine();

        System.out.print("Enter the second fraction: ");
        String frac2 = in.nextLine();
        Fraction fraction2 = new Fraction(Numerator(frac2), Denominator(frac2));

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

    public static void MainVariant2(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first fraction: ");
        String frac1 = in.nextLine();
        Fraction fraction1 = new Fraction(Numerator(frac1), Denominator(frac1));

        System.out.print("Enter the action: ");
        String action = in.nextLine();

        System.out.print("Enter the second fraction: ");
        String frac2 = in.nextLine();
        Fraction fraction2 = new Fraction(Numerator(frac2), Denominator(frac2));

        System.out.print("Result: ");

        switch (action){
            case "+":
                System.out.println(fraction1.SumFractionTo(fraction2).Print());
                break;
            case "-":
                System.out.println(fraction1.DifferenceFractionFrom(fraction2).Print());
                break;
            case ":":
                System.out.println(fraction1.QuotientThisFractionsTo(fraction2).Print());
                break;
            case "*":
                System.out.println(fraction1.ProductThisFractionTo(fraction2).Print());
                break;
        }
    }

    public static void main(String[] args) {
        // MainVariant1();
        MainVariant2();
    }
}