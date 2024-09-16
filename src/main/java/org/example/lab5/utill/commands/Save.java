package org.example.lab5.utill.commands;

import org.example.lab5.utill.managers.CollectionManager;
import org.example.lab5.utill.managers.FileManager;

public class Save extends AbstrctCommand {

    private FileManager fileManager;

    public Save(FileManager fileManager) {
        super("save", "сохраняет коллекцию в файл");
        this.fileManager = fileManager;
    }

    @Override
    public void execute() {
        fileManager.save();
        System.out.println("Все сохоранилось в файлик!");
    }
}
