package org.example.lab5.utill.commands;

import org.example.lab5.data.SpaceMarine;
import org.example.lab5.data.builder.SpaceMarineBuild;
import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;

public class AddIfMax extends AbstrctCommand {

    private CollectionManager collectionManager;
    private ConsoleInput input;

    public AddIfMax(ConsoleInput input, CollectionManager collectionManager) {
        super("add_if_max", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.collectionManager= collectionManager;
        this.input=input;
    }

    @Override
    public void execute() {
        SpaceMarine marine = collectionManager.sortedList().getLast();
        var x = marine.getCoordinates().getX();
        var y = marine.getCoordinates().getY();
        System.out.println("соберите новый объект, у которого координаты будут больше чем вот эти: " + x + "   " + y);
        SpaceMarine newMarine = new SpaceMarineBuild(input).build();

        if(Math.abs(newMarine.getCoordinates().getX()) > x || Math.abs(newMarine.getCoordinates().getX()) > y ) {
            collectionManager.addElement(newMarine);
            System.out.println("умничка");
        } else {
            System.err.println("зачем вызвал эту команду и не соблюдаешь условие????" +
                    "неправильно, попоробуй еще раз))");
        }
    }
}
