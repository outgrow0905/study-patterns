package com.example.patterns.I_TemplateMethod.v3;


import ch.qos.logback.core.testUtil.RandomUtil;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("open coffee-stick and pour in cup");
    }

    @Override
    void addCondiments() {
        System.out.println("add sugar");
    }

    @Override
    boolean hookCondition() {
        return RandomUtil.getPositiveInt() % 2 == 0;
    }

    @Override
    void hookAction() {
        System.out.println("you are lucky!");
    }
}
