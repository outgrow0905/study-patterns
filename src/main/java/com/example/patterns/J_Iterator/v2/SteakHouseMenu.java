package com.example.patterns.J_Iterator.v2;

import com.example.patterns.J_Iterator.MenuItem;

public class SteakHouseMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    int position = 0;

    public SteakHouseMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addMenuItem("black steak", "lamb", false, 45.99);
        addMenuItem("white steak", "duck", false, 24.99);
        addMenuItem("blue steak", "pig", false, 12.49);
    }

    public void addMenuItem(String name, String description, boolean vegetarian, double price){
        if (numberOfItems >= MAX_ITEMS) {
            throw new RuntimeException("menu is full");
        }

        menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
        numberOfItems++;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    boolean hasNext() {
        return position < numberOfItems;
    }

    MenuItem next() {
        return menuItems[position++];
    }
}
