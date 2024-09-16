package org.example.lab5.utill.commands;

import org.example.lab5.data.SpaceMarine;
import org.example.lab5.data.builder.SpaceMarineBuild;
import org.example.lab5.utill.managers.CollectionManager;
import org.example.lab5.utill.ConsoleInput;

public class Add extends AbstrctCommand{

    private ConsoleInput input;
    private CollectionManager collectionManager;

    public Add(ConsoleInput input, CollectionManager collectionManager) {
        super("add", "{element} добавление нового элемента в коллекцию");
        this.input = input;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
//        SpaceMarine spaceMarine = new SpaceMarineBuild(input).build();
        collectionManager.addElement(new SpaceMarineBuild(input).build());
        System.out.println("good!");
    }


}
