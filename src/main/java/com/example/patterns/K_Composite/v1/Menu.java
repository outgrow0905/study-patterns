package com.example.patterns.K_Composite.v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    String name;
    String description;
    List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    void addComposition(MenuComponent menuComposition) {
        menuComponents.add(menuComposition);
    }

    @Override
    void print() {
        System.out.println("Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}');

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}
