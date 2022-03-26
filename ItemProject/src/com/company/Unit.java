package com.company;

public class Unit implements Playable {
    private String name;
    private int health;

    public Unit(String name, int health) {
        this.name = name;
        this.health = health;
    }

    //getters
    public String getName() {
        return this.name;
    }
    public int getHealth(){
        return this.health;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health){
        this.health = health;
    }

    @Override
    public void attack() {
        System.out.println("Attack!");
    }

    @Override
    public void move() {
        System.out.println("Walk!");
    }

    @Override
    public void eat() {
        System.out.println("I'm eating!");
    }

    public void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
    }
}
