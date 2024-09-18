package org.example.lab5.utill.managers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.lab5.data.SpaceMarine;

import java.io.*;
import java.text.SimpleDateFormat;

// для создания файла, в котором будет храниться вся коллекция. файлик формата json
/**
 * Класс FileManager отвечает за управление файлами, в которых хранится коллекция SpaceMarine.
 * Он предоставляет методы для чтения, парсинга и сохранения данных в формате JSON.
 */
public class FileManager {
    // путь до файла
    private String path;
    private CollectionManager collectionManager;
    private File file;

    /**
     * Конструктор FileManager, который инициализирует путь к файлу и менеджер коллекции.
     *
     * @param collectionManager менеджер коллекции
     */
    public FileManager(String path,CollectionManager collectionManager) {
        // переменная окружения for work in term
        this.path = path;
        this.collectionManager = collectionManager;
        this.file = new File(path);
        // this.collectionManager.addElement(findFile());
    }


    /**
     * Устанавливает путь к файлу.
     *
     * @param path путь к файлу
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Читает содержимое файла и возвращает его в виде строки.
     *
     * @return содержимое файла в виде строки
     */
    public String readFile() {
        if (path == null || path.isEmpty() || !file.exists()) {
            System.err.println("Где путь? Где файл? Что происходит?");
            System.exit(1);
        } else {
            try {
                FileInputStream fileStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileStream);

                StringBuilder line = new StringBuilder();
                int x;
                while ((x = inputStreamReader.read()) != -1) {
                    line.append((char) x);
                }
                String txt = line.toString();
                inputStreamReader.close();
                return txt;
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Парсит строку JSON и возвращает массив объектов SpaceMarine.
     *
     * @param json строка в формате JSON
     * @return массив SpaceMarine или null в случае ошибки
     */
    public SpaceMarine[] parseSpaceMarines(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            return objectMapper.readValue(json, SpaceMarine[].class);
        } catch (IOException e) {
            System.err.println("Ошибка при парсинге JSON: " + e.getMessage());
            return null;
        }
    }

    /**
     * Сохраняет массив SpaceMarine в файл в формате JSON.
     */
    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // этот модуль поддерживает все эти штуки с датой
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            // Устанавливаем формат даты
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            // пишем в файл массив спасе марины (Марин, их много) very
            mapper.writeValue(file, collectionManager.getSpaceMarineArray());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}