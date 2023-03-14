package com.example.patterns.K_Composite.v1;
import java.util.ArrayList;

public class PancakeHouseMenu extends Menu {
    public PancakeHouseMenu(String name, String description) {
        super(name, description);
        addComposition(new MenuItem("King pancake set", "pancake with eggs and toast, coffee", true, 3.99));
        addComposition(new MenuItem("Queen pancake set", "pancake with sausage, milk", false, 2.99));
        addComposition(new MenuItem("Blueberry pancake", "pancake with blueberries", true, 1.99));
        addComposition(new MenuItem("Waffle", "waffle with apple syrup", true, 1.49));
    }
}
