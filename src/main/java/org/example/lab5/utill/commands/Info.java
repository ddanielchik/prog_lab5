package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CollectionManager;

public class Info extends AbstrctCommand{

    private CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        System.out.println(collectionManager.getAll());
    }
}
