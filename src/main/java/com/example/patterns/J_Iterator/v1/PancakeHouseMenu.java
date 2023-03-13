package com.example.patterns.J_Iterator.v1;

import com.example.patterns.J_Iterator.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addMenuItem("King pancake set", "pancake with eggs and toast, coffee", true, 3.99);
        addMenuItem("Queen pancake set", "pancake with sausage, milk", false, 2.99);
        addMenuItem("blueberry pancake", "pancake with blueberries", true, 1.99);
        addMenuItem("waffle", "waffle with apple syrup", true, 1.49);
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price){
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
