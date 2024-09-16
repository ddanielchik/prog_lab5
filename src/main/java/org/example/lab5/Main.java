package org.example.lab5;

import org.example.lab5.data.SpaceMarine;
import org.example.lab5.utill.ConsoleInput;
import org.example.lab5.utill.managers.CollectionManager;
import org.example.lab5.utill.managers.CommandManager;
import org.example.lab5.utill.managers.FileManager;

import java.util.ArrayList;
import java.util.Collections;




public class Main {
    public static void main(String[] args){

        CollectionManager collectionManager = new CollectionManager();
        ConsoleInput input = new ConsoleInput();
        FileManager fileManager = new FileManager(collectionManager);
//        fileManager.setPath(args[0]);//нужна 1-ая строка, кот ук пользователь
        CommandManager commandManager = new CommandManager(collectionManager, input, fileManager);
        System.out.println("ты можешь начать тыкать на кнопочки _-_-_-__-");

        System.out.println(fileManager.readFile());
        collectionManager.addAll(fileManager.parseSpaceMarines(fileManager.readFile()));

        while (true) {

            // все что мы пишем это будет переводиться в  txt
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
