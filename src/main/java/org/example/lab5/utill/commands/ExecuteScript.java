package org.example.lab5.utill.commands;

import org.example.lab5.data.*;
import org.example.lab5.data.builder.ChapterBuild;
import org.example.lab5.data.builder.CoordinatesBuild;
import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;
import org.example.lab5.utill.managers.CommandManager;
import org.example.lab5.utill.managers.FileManager;

import java.io.*;

/**
 * Класс, представляющий команду для выполнения скрипта из указанного файла.
 * Наследуется от абстрактного класса AbstrctCommand.
 */
public class ExecuteScript extends AbstrctCommand {

    private CollectionManager collectionManager;
    private FileManager fileManager = new FileManager(collectionManager);
    private CommandManager commandManager;
    private ConsoleInput input;

    /**
     * Конструктор класса ExecuteScript.
     *
     * @param input объект для ввода данных с консоли
     * @param commandManager менеджер команд
     * @param collectionManager менеджер коллекции
     */
    public ExecuteScript(ConsoleInput input, CommandManager commandManager, CollectionManager collectionManager) {
        super("execute_script", " считать и исполнить скрипт из указанного файла ");
        this.commandManager = commandManager;
        this.input = input;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет скрипт из указанного файла.
     * Считывает команды из файла и выполняет их.
     */
    @Override
    public void execute() {
        String path = input.next(); // Получаем путь к файлу от пользователя
        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            System.err.println("Файл не найден или это не файл: " + path);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("add")) { // Предполагаем, что команда для добавления SpaceMarine начинается с "add"
                    SpaceMarine spaceMarine = parseSpaceMarine(reader); // Парсим следующие строки для создания SpaceMarine
                    if (spaceMarine != null) {
                        collectionManager.addElement(spaceMarine); // Добавляем созданный SpaceMarine в коллекцию
                    }
                } else {
                    commandManager.execute(line); // Выполняем другие команды
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    /**
     * Парсит данные для создания объекта SpaceMarine из BufferedReader.
     *
     * @param reader BufferedReader для чтения данных
     * @return созданный объект SpaceMarine или null, если произошла ошибка
     * @throws IOException если произошла ошибка чтения
     */
    private SpaceMarine parseSpaceMarine(BufferedReader reader) throws IOException {
        String name = null;
        Coordinates coordinates = null;
        long health = 0;
        AstartesCategory category = null;
        Weapon weapon = null;
        MeleeWeapon meleeWeapon = null;
        Chapter chapter = null;

        try {
            // Читаем имя
            name = reader.readLine();
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Имя не может быть пустым.");
            }

            // Читаем координаты
            try {
                double x = Double.parseDouble(reader.readLine());
                long y = Long.parseLong(reader.readLine());
                coordinates = new Coordinates(x, y);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка ввода координат: " + e.getMessage());
                return null; // Возвращаем null, если координаты некорректны
            }

            // Читаем здоровье
            try {
                health = Long.parseLong(reader.readLine());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка ввода здоровья: " + e.getMessage());
                return null; // Возвращаем null, если здоровье некорректно
            }

            // Читаем категорию
            try {
                category = AstartesCategory.valueOf(reader.readLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Некорректная категория Astartes: " + e.getMessage());
                return null; // Возвращаем null, если категория некорректна
            }

            // Читаем оружие
            try {
                weapon = Weapon.valueOf(reader.readLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Некорректное оружие: " + e.getMessage());
                return null; // Возвращаем null, если оружие некорректно
            }

            // Читаем ближнее оружие
            try {
                meleeWeapon = MeleeWeapon.valueOf(reader.readLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Некорректное ближнее оружие: " + e.getMessage());
                return null; // Возвращаем null, если ближнее оружие некорректно
            }

            // Читаем главу
            try {
                String chapterName = reader.readLine();
                String chapterWorld = reader.readLine();
                long chapterMarinesCount = Long.parseLong(reader.readLine());
                chapter = new Chapter(chapterName, chapterWorld, chapterMarinesCount, reader.readLine());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка ввода данных главы: " + e.getMessage());
                return null; // Возвращаем null, если данные главы некорректны
            }

            // Создаем и возвращаем объект SpaceMarine
            return new SpaceMarine(name, coordinates, health, category, weapon, meleeWeapon, chapter);
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла: " + e.getMessage());
            return null; // Возвращаем null, если произошла ошибка чтения
        }
    }
}
