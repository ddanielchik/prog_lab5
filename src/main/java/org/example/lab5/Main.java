package org.example.lab5;

import org.example.lab5.data.SpaceMarine;
import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;
import org.example.lab5.utill.managers.CommandManager;
import org.example.lab5.utill.managers.FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Вы не передали файл, попробуйте еще раз");
            System.exit(1);
        }

        String filePath = args[0];
        System.out.println("Путь к файлу: " + filePath.trim()); // Для отладки

        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Файл не найден: " + filePath.trim());
            System.exit(1);
        }

        CollectionManager collectionManager = new CollectionManager();
        ConsoleInput input = new ConsoleInput();
        FileManager fileManager = new FileManager(filePath.trim(), collectionManager);

        CommandManager commandManager = new CommandManager(collectionManager, input, fileManager);
        System.out.println("Ты можешь начать тыкать на кнопочки _-_-_-__-");

        System.out.println(fileManager.readFile());
        collectionManager.addAll(fileManager.parseSpaceMarines(fileManager.readFile()));

        while (true) {
            String txt = input.next();
            commandManager.execute(txt);
        }
    }
}

//        SpaceMarine o1 = new SpaceMarine(1L, "123", new Coordinates(123, 123), ZonedDateTime.now(), 123, AstartesCategory.TACTICAL, Weapon.BOLTGUN, MeleeWeapon.CHAIN_SWORD, new Chapter("name", "123", 123L, "123"));
//        ObjectMapper mapper =  new ObjectMapper();
//        File file = new File("txt.json");
//        try {
//            mapper.registerModule(new JavaTimeModule());
//            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//            // Устанавливаем формат даты
////            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
//            mapper.writeValue(file, o1);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }









