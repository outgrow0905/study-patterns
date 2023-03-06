package com.example.patterns.F_Command.v3;

public class RemoteController {

    private Command button1;
    private Command button2;

    public RemoteController(Command button1, Command button2) {
        this.button1 = button1;
        this.button2 = button2;
    }

    public void button1Pressed() {
        this.button1.execute();
    }

    public void button2Pressed() {
        this.button2.execute();
    }
}
