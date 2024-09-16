package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CommandManager;

import java.util.List;

public class History extends AbstrctCommand{
    private CommandManager commandManager;

    public History(CommandManager commandManager) {
        super("history", "показывает список последних команд");
        this.commandManager= commandManager;

    }
    @Override
    public void execute() {
        List<String> history = commandManager.getCommandHistory();

        history.stream()
                .skip(Math.max(0, history.size() - 5))
                .map(command -> command)
                .forEach(System.out::println);
    }


}
