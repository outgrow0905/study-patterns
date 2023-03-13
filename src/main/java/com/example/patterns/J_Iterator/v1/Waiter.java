package com.example.patterns.J_Iterator.v1;

import com.example.patterns.J_Iterator.MenuItem;

import java.util.ArrayList;

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
        for (int i = 0; i < pancakeHouseMenu.getMenuItems().size(); i++) {
            System.out.println("name: " + pancakeHouseMenu.getMenuItems().get(i).getName());
            System.out.println("description: " + pancakeHouseMenu.getMenuItems().get(i).getDescription());
            System.out.println("price: " + pancakeHouseMenu.getMenuItems().get(i).getPrice());
        }
    }

    void printDinnerMenu() {
        for (int i = 0; i < steakHouseMenu.numberOfItems; i++) {
            System.out.println("name: " + steakHouseMenu.getMenuItems()[i].getName());
            System.out.println("description: " + steakHouseMenu.getMenuItems()[i].getDescription());
            System.out.println("price: " + steakHouseMenu.getMenuItems()[i].getPrice());
        }
    }
}
