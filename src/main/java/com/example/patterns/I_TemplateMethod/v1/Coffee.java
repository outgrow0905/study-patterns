package com.example.patterns.I_TemplateMethod.v1;

public class Coffee {

    public void prepare() {
        boilWater();
        openCoffeeStickAndPourInCup();
        pourInCup();
        addSugar();
    }

    public void boilWater() {
        System.out.println("boil water");
    }

    public void openCoffeeStickAndPourInCup() {
        System.out.println("open coffee-stick and pour in cup");
    }

    public void pourInCup() {
        System.out.println("pour in cup");
    }

    public void addSugar() {
        System.out.println("add sugar");
    }
}
