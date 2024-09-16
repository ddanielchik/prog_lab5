package org.example.lab5.utill.commands;

import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;

public class Show extends AbstrctCommand {
    private CollectionManager collectionManager;
    public Show(CollectionManager collectionManager) {
        super("show", "выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager=collectionManager;

    }

    @Override
    public void execute() {
        //getAll- выводит все содердимое коллекции
//        System.out.println(collectionManager.getAll());
        System.out.println(collectionManager.getCollection());
    }

}
