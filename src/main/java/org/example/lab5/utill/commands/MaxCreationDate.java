package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CollectionManager;

// надо обратиться к коллеции и получить все имеющиеся элементы
// из эл-ов вывести только дату
// из дат вывести максимальную
// делать все при помощи лямбд выражений
// в space marine вывести get creation date
public class MaxCreationDate extends AbstrctCommand {

    private CollectionManager collectionManager;

    public MaxCreationDate(CollectionManager collectionManager) {
        super("max_creation_date", "вывести любой объект из коллекции, значение поля creationDate которого является максимальным");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        System.out.println("max date is: " + collectionManager.getMaxDate());
    }
}
