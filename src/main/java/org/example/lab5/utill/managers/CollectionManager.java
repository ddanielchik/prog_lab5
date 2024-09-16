package org.example.lab5.utill.managers;

import org.example.lab5.data.SpaceMarine;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionManager {

    private LinkedHashSet<SpaceMarine> collection = new LinkedHashSet<>();

    // текущий айди
    private long totalId = 1;
// изменить логику учета id

    public LinkedHashSet<SpaceMarine> getCollection() {
        return collection;
    }

    public List<SpaceMarine> sortedList(){
        List<SpaceMarine> sortedList = new ArrayList<>(collection);
        Collections.sort(sortedList);

        for (SpaceMarine marine : sortedList) {
            System.out.println(marine);
        }
        return sortedList;
    }

    public SpaceMarine[] getSpaceMarineArray() {
        return collection.toArray(new SpaceMarine[0]);
    }

    public void addAll(SpaceMarine[] spaceMarines) {
        if (spaceMarines != null) {
            for (SpaceMarine spaceMarine : spaceMarines) {
                addElement(spaceMarine);
            }
        }
    }

    public void addElement(SpaceMarine spaceMarine) {
        spaceMarine.setId(this.totalId);
        collection.add(spaceMarine);
        this.totalId++;
    }

    public void dropAll() {
        collection.clear();
    }

    public String getAll() {
        return collection.stream()
                .map(SpaceMarine::toString)
                .collect(Collectors.joining("\n"));
    }

    public String getMaxDate() {
        return collection.stream()
                .max(Comparator.comparing(SpaceMarine::getCreationDate))
                .map(spaceMarine -> spaceMarine.getCreationDate().toString())
                .orElse("Ничего нет");
    }

    public String getAllWeapon() {
        return collection.stream()
                // map- собирает все резы в одно значение (спас марины)
                // этот спас собираетсчя в строки из строчек ниже
                .map(spaceMarine -> spaceMarine.getId() + " - " + spaceMarine.getWeaponType()) // Создаем строку, содержащую ID и тип оружия
                // коллект собирает все значения
                .collect(Collectors.joining("\n")); // Объединяем строки, разделяя их переводом строки
    }


    public void update(long id, SpaceMarine spaceMarine) {
        deleteByID(id);
        spaceMarine.setId(id);
        collection.add(spaceMarine);
    }

    public SpaceMarine getById(long id) {
        for (SpaceMarine spaceMarine : collection) {
            if (spaceMarine.getId() == id) {
                return spaceMarine;
            }
        }
        return null;
    }

    //треш, нада учить лямбда выражения
    public void deleteByID(long id) {
        if (getById(id) == null) {
            System.err.println("not found 404, please try again");
        } else {
            collection.remove(getById(id));
        }
    }
}
