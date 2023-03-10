package com.example.patterns.I_TemplateMethod.v2;

public abstract class CaffeineBeverage {

    final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("boil water");
    }

    private void pourInCup() {
        System.out.println("pour in cup");
    }

    abstract void brew();
    abstract void addCondiments();


}
