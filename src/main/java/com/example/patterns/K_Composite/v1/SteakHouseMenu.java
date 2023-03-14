package com.example.patterns.K_Composite.v1;

public class SteakHouseMenu extends Menu {
    public SteakHouseMenu(String name, String description) {
        super(name, description);
        addComposition(new MenuItem("black steak", "lamb", false, 45.99));
        addComposition(new MenuItem("white steak", "duck", false, 24.99));
        addComposition(new MenuItem("blue steak", "pig", false, 12.49));
    }
}
