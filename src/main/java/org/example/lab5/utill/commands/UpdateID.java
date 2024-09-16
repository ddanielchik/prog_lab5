package org.example.lab5.utill.commands;

import org.example.lab5.data.SpaceMarine;
import org.example.lab5.data.builder.SpaceMarineBuild;
import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;

public class UpdateID extends AbstrctCommand {
    private CollectionManager collectionManager;
    private ConsoleInput input;

    public UpdateID(CollectionManager collectionManager, ConsoleInput input) {
        super("updateID", "{element}: обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.input = input;
    }

    @Override
    public void execute() {
        System.out.println("тыкай свой айдишник");
        long id = Long.parseLong(input.next());
        collectionManager.update(id, new SpaceMarineBuild(input).build());

//        System.out.println("тыкай свой new айдишник");
//        long newID = Long.parseLong(input.next());
//        collectionManager.update(id, newID);
//        System.out.println("Всё гатова))");
    }
}
