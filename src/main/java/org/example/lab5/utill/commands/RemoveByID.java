package org.example.lab5.utill.commands;

import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;

public class RemoveByID  extends AbstrctCommand{

    private CollectionManager collectionManager;
    private ConsoleInput consoleInput;


    public RemoveByID(ConsoleInput consoleInput, CollectionManager collectionManager) {
        super("removeID", "delete element by id");

        this.collectionManager = collectionManager;
        this.consoleInput = consoleInput;
    }

    @Override
    public void execute() {
        System.out.println("input id");
        collectionManager.deleteByID(Long.parseLong(consoleInput.next()));
        System.out.println("vse ok!");

    }
}
