package org.example.lab5.utill.managers;

import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.commands.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommandManager {

    private Map<String, AbstrctCommand> commandMap = new HashMap<>();
    //бред какой-то...
    private final List<String> commandHistory = new CopyOnWriteArrayList<>();
    //... можем передать негораниченное кол-во объектов конструктору
    public CommandManager(CollectionManager collectionManager, ConsoleInput consoleInput, FileManager fileManager) {
        addCommand(new History(this));
        addCommand(new Show(collectionManager));
        addCommand(new Clear(collectionManager));
        addCommand(new Help(this));
        addCommand(new Add(consoleInput, collectionManager));
        addCommand(new Info(collectionManager));
        addCommand(new Exit());
        addCommand(new UpdateID(collectionManager, consoleInput));
        addCommand(new RemoveByID(consoleInput, collectionManager));
        addCommand(new PrintAscendingWeapon(collectionManager));
        addCommand(new MaxCreationDate(collectionManager));
        addCommand(new Save(fileManager));
        addCommand(new AddIfMax(consoleInput, collectionManager));
        addCommand(new AddIfMin(consoleInput, collectionManager));
        addCommand(new AverageHealth(collectionManager));
        addCommand(new ExecuteScript(consoleInput, this, collectionManager));

    }

    public void addCommand(AbstrctCommand command){
        commandMap.put(command.getName(), command);
    }

    public void printAllCommands() {
        for (AbstrctCommand command : commandMap.values()) {
            command.printCommand();
        }
    }

    public void execute(String commandName) {
        AbstrctCommand command = commandMap.get(commandName);
        if (command != null) {
            command.execute();
            addToHistory(commandName);
        } else {
            System.out.println("Command not found: " + commandName);
        }
    }

//    public void execute(String commandName, String txt) {
//        AbstrctCommand command = commandMap.get(commandName);
//        if (command != null) {
//            command.execute(txt);
//            addToHistory(commandName);
//        } else {
//            System.out.println("Command not found: " + commandName);
//        }
//    }

    //переделать какая-то хуита (ниже)
    public void addToHistory(String line) {
        if (line != null && !line.isBlank()) {
            this.commandHistory.add(line);
        }
    }

    public List<String> getCommandHistory() {
        return Collections.unmodifiableList(commandHistory);
    }

}
