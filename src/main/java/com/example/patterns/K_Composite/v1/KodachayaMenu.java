package com.example.patterns.K_Composite.v1;

public class KodachayaMenu extends Menu {
    public KodachayaMenu(String name, String description) {
        super(name, description);
        Menu kimbob = new Menu("Kimbab heaven", "welcome");
        kimbob.addComposition(new MenuItem("Kimbob", "common Kimbob", true, 1.49));
        kimbob.addComposition(new MenuItem("Toppokki", "common Toppokki", true, 0.99));

        Menu seafood = new Menu("Seafood heaven", "welcome");
        seafood.addComposition(new MenuItem("seaweed", "seaweed", true, 0.49));
        seafood.addComposition(new MenuItem("squid", "squid", true, 4.49));

        addComposition(kimbob);
        addComposition(seafood);
    }
}
