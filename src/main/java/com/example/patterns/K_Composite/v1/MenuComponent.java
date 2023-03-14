package com.example.patterns.K_Composite.v1;

public abstract class MenuComponent {
    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    boolean isVegetarian(){
        throw new UnsupportedOperationException();
    }

    double getPrice(){
        throw new UnsupportedOperationException();
    }


    void addComposition(MenuComponent menuComposition) {
        throw new UnsupportedOperationException(); // MenuItem에는 없지만 추가한다. 아래에서 설명한다.
    }

    void print() {
        throw new UnsupportedOperationException(); // MenuItem에는 없지만 추가한다. 아래에서 설명한다.
    }
}
