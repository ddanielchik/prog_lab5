package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CollectionManager;

public class PrintAscendingWeapon extends AbstrctCommand{

    private CollectionManager collectionManager;

    public PrintAscendingWeapon( CollectionManager collectionManager) {
        super("print", "вывести значения поля weaponType всех элементов в порядке возрастания");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        System.out.println("all list weapons with ID");
        System.out.println(collectionManager.getAllWeapon());
        System.out.println("the end ...");
    }
}
