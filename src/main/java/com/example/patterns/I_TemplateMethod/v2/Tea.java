package com.example.patterns.I_TemplateMethod.v2;

public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("steep teabag");
    }

    @Override
    void addCondiments() {
        System.out.println("add lemon");
    }
}
