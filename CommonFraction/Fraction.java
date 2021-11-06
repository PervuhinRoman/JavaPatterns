package com.company;

class Fraction {
    private int numerator, denominator = 1;  // числитель и знаменатель соответственно

    // конструктор
    public Fraction(int numerator, int denominator){
        if(denominator == 0){
            System.out.println("Denominator can't be zero :( Try again.");
            return;
        }

        this.numerator = numerator * (denominator < 0 ? -1 : 1);
        this.denominator = Math.abs(denominator);

        normalization();
    }

    // геттеры
    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }

    // сеттеры
    public void setNumerator(int numerator){this.numerator = numerator;}
    public void setDenominator(int denominator){
        if(denominator == 0){
            System.out.println("Denominator can't be zero :( Try again.");
            return;
        }

        this.numerator = numerator * (denominator < 0 ? -1 : 1);
        this.denominator = Math.abs(denominator);
    }

    // НОД для сокращения дроби (существует рекурсивный вариант, но он выполняется дольше)
    private int gcd(int numerator, int denominator){
        while(numerator != 0 & denominator != 0){
            if(numerator > denominator)
                numerator %= denominator;
            else
                denominator %= numerator;
        }

        return numerator + denominator;
    }

    // сокращение дроби
    private void normalization(){
        int n = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= n;
        denominator /= n;
    }

    //проверка правильная ли дробь
    public boolean properFraction(){
        return (Math.abs(numerator) < denominator ? true : false);
    }

    // получение целой части
    public int getWholePart(){
        return (numerator / denominator);
    }

    // полуение дробной части
    public Fraction fractionalPart(){
        return new Fraction(numerator % denominator, denominator);
    }

    // приведение к виду десятичной дроби
    public double toDecimalFraction(){
        return (double) numerator / denominator;
    }

    // вывод дроби в виде обыкновенной
    public String Print(){
        return new String(numerator + " / " + denominator);
    }

    // сумма дробей
    public Fraction SumFractionTo(Fraction obj){
        return new Fraction(this.numerator * obj.denominator + obj.numerator * this.denominator, this.denominator * obj.denominator);
    }

    public Fraction SumFractions(Fraction obj1, Fraction obj2){
        return new Fraction(obj1.numerator * obj2.denominator + obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
    }

    // разность дробей
    public Fraction DifferenceFractionFrom(Fraction obj){
        return new Fraction(this.numerator * obj.denominator - obj.numerator * this.denominator, this.denominator * obj.denominator);
    }

    public Fraction DifferenceFractions(Fraction obj1, Fraction obj2){
        return new Fraction(obj1.numerator * obj2.denominator - obj2.numerator * obj1.denominator, obj1.denominator * obj2.denominator);
    }

    // произведение дробей
    public Fraction ProductThisFractionTo(Fraction obj){
        return new Fraction(this.numerator * obj.numerator, this.denominator * obj.denominator);
    }

    public Fraction ProductFractions(Fraction obj1, Fraction obj2){
        return new Fraction(obj1.numerator * obj2.numerator, obj1.denominator * obj2.denominator);
    }

    // частное дробей
    public Fraction QuotientThisFractionsTo(Fraction obj){
        return new Fraction(this.numerator * obj.denominator, this.denominator * obj.numerator);
    }

    public Fraction QuotientFractions(Fraction obj1, Fraction obj2){
        return new Fraction(obj1.numerator * obj2.denominator, obj1.denominator * obj2.numerator);
    }
}
