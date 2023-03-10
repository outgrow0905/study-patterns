package com.example.patterns.I_TemplateMethod.v2;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("open coffee-stick and pour in cup");
    }

    @Override
    void addCondiments() {
        System.out.println("add sugar");
    }
}
