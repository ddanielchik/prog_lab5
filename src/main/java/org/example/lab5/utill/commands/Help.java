package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CommandManager;

public class Help extends AbstrctCommand{
    private CommandManager commandManager;

    public Help(CommandManager commandManager) {
        super("help", "отображение всех команд с описанием");
        this.commandManager = commandManager;
    }

    @Override
    public void execute() {
        commandManager.printAllCommands();
    }
}
