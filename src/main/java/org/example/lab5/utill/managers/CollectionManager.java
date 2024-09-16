package org.example.lab5.utill.managers;

import org.example.lab5.data.SpaceMarine;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс CollectionManager управляет коллекцией объектов SpaceMarine.
 * Он предоставляет методы для добавления, удаления, обновления и получения информации о SpaceMarine.
 */
public class CollectionManager {

    private LinkedHashSet<SpaceMarine> collection = new LinkedHashSet<>();

    // текущий айди
    private long totalId = 1; // изменить логику учета id

    /**
     * Возвращает коллекцию SpaceMarine.
     *
     * @return коллекция SpaceMarine
     */
    public LinkedHashSet<SpaceMarine> getCollection() {
        return collection;
    }

    /**
     * Возвращает отсортированный список SpaceMarine.
     * Сортировка выполняется по умолчанию.
     *
     * @return отсортированный список SpaceMarine
     */
    public List<SpaceMarine> sortedList() {
        List<SpaceMarine> sortedList = new ArrayList<>(collection);
        Collections.sort(sortedList);

        for (SpaceMarine marine : sortedList) {
            System.out.println(marine);
        }
        return sortedList;
    }

    /**
     * Возвращает массив SpaceMarine из коллекции.
     *
     * @return массив SpaceMarine
     */
    public SpaceMarine[] getSpaceMarineArray() {
        return collection.toArray(new SpaceMarine[0]);
    }

    /**
     * Добавляет массив SpaceMarine в коллекцию.
     *
     * @param spaceMarines массив SpaceMarine для добавления
     */
    public void addAll(SpaceMarine[] spaceMarines) {
        if (spaceMarines != null) {
            for (SpaceMarine spaceMarine : spaceMarines) {
                addElement(spaceMarine);
            }
        }
    }

    /**
     * Добавляет элемент SpaceMarine в коллекцию и устанавливает ему уникальный ID.
     *
     * @param spaceMarine элемент SpaceMarine для добавления
     */
    public void addElement(SpaceMarine spaceMarine) {
        spaceMarine.setId(this.totalId);
        collection.add(spaceMarine);
        this.totalId++;
    }

    /**
     * Очищает коллекцию SpaceMarine.
     */
    public void dropAll() {
        collection.clear();
    }

    /**
     * Возвращает строковое представление всех SpaceMarine в коллекции.
     *
     * @return строка, содержащая информацию о всех SpaceMarine
     */
    public String getAll() {
        return collection.stream()
                .map(SpaceMarine::toString)
                .collect(Collectors.joining("\n"));
    }

    /**
     * Возвращает дату создания SpaceMarine с самой поздней датой.
     *
     * @return строка с самой поздней датой создания или сообщение "Ничего нет", если коллекция пуста
     */
    public String getMaxDate() {
        return collection.stream()
                .max(Comparator.comparing(SpaceMarine::getCreationDate))
                .map(spaceMarine -> spaceMarine.getCreationDate().toString())
                .orElse("Ничего нет");
    }

    /**
     * Возвращает строку, содержащую ID и тип оружия для каждого SpaceMarine в коллекции.
     *
     * @return строка с ID и типами оружия
     */
    public String getAllWeapon() {
        return collection.stream()
                // map- собирает все резы в одно значение (спас марины)
                // этот спас собираетсчя в строки из строчек ниже
                .map(spaceMarine -> spaceMarine.getId() + " - " + spaceMarine.getWeaponType()) // Создаем строку, содержащую ID и тип оружия
                // коллект собирает все значения
                .collect(Collectors.joining("\n")); // Объединяем строки, разделяя их переводом строки
    }

    /**
     * Обновляет элемент SpaceMarine в коллекции по заданному ID.
     *
     * @param id          уникальный идентификатор SpaceMarine для обновления
     * @param spaceMarine новый объект SpaceMarine
     */
    public void update(long id, SpaceMarine spaceMarine) {
        deleteByID(id);
        spaceMarine.setId(id);
        collection.add(spaceMarine);
    }

    /**
     * Возвращает SpaceMarine по заданному ID.
     *
     * @param id уникальный идентификатор SpaceMarine
     * @return SpaceMarine с заданным ID или null, если не найден
     */
    public SpaceMarine getById(long id) {
        for (SpaceMarine spaceMarine : collection) {
            if (spaceMarine.getId() == id) {
                return spaceMarine;
            }
        }
        return null;
    }

    //треш, нада учить лямбда выражения
    /**
     * Удаляет SpaceMarine из коллекции по заданному ID.
     *
     * @param id уникальный идентификатор SpaceMarine для удаления
     */
    public void deleteByID(long id) {
        if (getById(id) == null) {
            System.err.println("not found 404, please try again");
        } else {
            collection.remove(getById(id));
        }
    }
}
