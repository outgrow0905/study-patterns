package com.example.patterns.F_Command.v3;

import java.util.List;

public class MegaCommand implements Command {
    private List<Command> commands;

    public MegaCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
