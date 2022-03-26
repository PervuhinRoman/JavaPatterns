package com.company;

public class Wizard extends Unit{
    private int mana;

    public Wizard(String name, int health, int mana){
        super(name, health);
        this.mana = mana;
    }

    // getters
    public int getMana(){
        return this.mana;
    }

    // setters
    public void setMana(int mana){
        this.mana = mana;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Wizard's mana: " + this.mana);
    }
}
