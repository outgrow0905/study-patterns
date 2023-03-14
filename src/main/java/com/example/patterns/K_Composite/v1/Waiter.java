package com.example.patterns.K_Composite.v1;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    List<Menu> menus = new ArrayList<>();

    public Waiter(List<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        for (Menu menu : menus) {
            menu.print();
        }
    }
}
