package com.example.patterns.J_Iterator.v5;

import com.example.patterns.J_Iterator.MenuItem;

public class ArrayIterator implements Iterator {

    MenuItem[] menuItems;
    int position = 0;

    public ArrayIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (null == menuItems[position]) {
            return false;
        }

        return position < menuItems.length;
    }

    @Override
    public MenuItem next() {
        return menuItems[position++];
    }
}
