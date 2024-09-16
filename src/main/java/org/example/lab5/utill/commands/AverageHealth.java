package org.example.lab5.utill.commands;

import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;
import org.example.lab5.data.SpaceMarine;

public class AverageHealth extends AbstrctCommand {

    private CollectionManager collectionManager;

    public AverageHealth(CollectionManager collectionManager) {
        super("average_health", "get average health collection elements");
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        System.out.println(collectionManager.getCollection().stream().mapToLong(SpaceMarine::getHealth) // Извлекаем здоровье каждого
                .average() // Вычисляем среднее значение\
                .orElse(0.0)); // Если коллекция пуста, возвращаем 0.0
    }
}
