package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CollectionManager;

public class Clear extends AbstrctCommand{

    private CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.dropAll();
        System.out.println("collection clear!");
    }
}
