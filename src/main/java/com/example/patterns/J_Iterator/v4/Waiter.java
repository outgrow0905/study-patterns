package com.example.patterns.J_Iterator.v4;

import com.example.patterns.J_Iterator.MenuItem;

public class Waiter {

    PancakeHouseMenu pancakeHouseMenu;
    SteakHouseMenu steakHouseMenu;

    public Waiter(PancakeHouseMenu pancakeHouseMenu, SteakHouseMenu steakHouseMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.steakHouseMenu = steakHouseMenu;
    }

    void printMenu() {
        printLunchMenu();
        printDinnerMenu();
    }

    void printLunchMenu() {
        Iterator iterator = pancakeHouseMenu.createIterator();

        while(iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println("name: " + menuItem.getName());
            System.out.println("description: " + menuItem.getDescription());
            System.out.println("price: " + menuItem.getPrice());
        }
    }

    void printDinnerMenu() {
        Iterator iterator = steakHouseMenu.createIterator();

        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println("name: " + menuItem.getName());
            System.out.println("description: " + menuItem.getDescription());
            System.out.println("price: " + menuItem.getPrice());
        }
    }
}
