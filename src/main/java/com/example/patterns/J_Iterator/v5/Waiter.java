package com.example.patterns.J_Iterator.v5;

import com.example.patterns.J_Iterator.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

public class Waiter {

    ArrayList<Menu> menuItems;


    public Waiter(ArrayList<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    void printMenu() {
        Iterator iterator = menuItems.iterator(); // java.util.Iterator
        while (iterator.hasNext()) {
            com.example.patterns.J_Iterator.v5.Iterator menuIterator = ((Menu) iterator.next()).createIterator();
            while(menuIterator.hasNext()) {
                MenuItem menuItem = menuIterator.next();
                System.out.println("name: " + menuItem.getName());
                System.out.println("description: " + menuItem.getDescription());
                System.out.println("price: " + menuItem.getPrice());
            }
        }
    }
}
