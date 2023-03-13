package com.example.patterns.J_Iterator.v4;

import com.example.patterns.J_Iterator.MenuItem;

import java.util.ArrayList;

public class ListIterator implements Iterator {

    ArrayList<MenuItem> menuItems;
    int position = 0;

    public ListIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }

    @Override
    public MenuItem next() {
        return menuItems.get(position++);
    }
}
