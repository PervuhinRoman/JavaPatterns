package com.company;

public class Robot extends Unit{
    private int armor;

    public Robot(String name, int health, int armor) {
        super(name, health);
        this.armor = armor;
    }

    // getters
    public int getArmor() {
        return this.armor;
    }

    // setters
    @Override
    public void setName(String name) {
        super.setName("_" + name + "_");
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void attack(){
        System.out.println("Robot's attack!");
    }

    @Override
    public void printInfo(){
        System.out.println("Robot's name: " + getName());
        System.out.println("Robot's health: " + getHealth());
        System.out.println("Robot's armor: " + getArmor());
    }
}
