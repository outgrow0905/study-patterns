package com.example.patterns.I_TemplateMethod.v1;

public class Tea {

    public void prepare() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    public void boilWater() {
        System.out.println("boil water");
    }

    public void steepTeaBag() {
        System.out.println("steep teabag");
    }

    public void pourInCup() {
        System.out.println("pour in cup");
    }

    public void addLemon() {
        System.out.println("add lemon");
    }
}
