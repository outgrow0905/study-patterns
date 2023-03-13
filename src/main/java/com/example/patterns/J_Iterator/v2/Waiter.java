package com.example.patterns.J_Iterator.v2;

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
        while(pancakeHouseMenu.hasNext()) {
            MenuItem menuItem = pancakeHouseMenu.next();
            System.out.println("name: " + menuItem.getName());
            System.out.println("description: " + menuItem.getDescription());
            System.out.println("price: " + menuItem.getPrice());
        }
    }

    void printDinnerMenu() {
        while (steakHouseMenu.hasNext()) {
            MenuItem menuItem = steakHouseMenu.next();
            System.out.println("name: " + menuItem.getName());
            System.out.println("description: " + menuItem.getDescription());
            System.out.println("price: " + menuItem.getPrice());
        }
    }
}
