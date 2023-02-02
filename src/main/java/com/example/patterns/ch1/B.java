package com.example.patterns.ch1;

public class B {
    String one;
    String two;
    String three;
    A a;

    public C getC(String one, String two, String three) {
        if (a.isDelicious) {
            return new CDecorator(new C());
        }

        return new C();
    }
}
