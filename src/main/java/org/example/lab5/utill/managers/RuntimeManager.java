//package org.example.lab5.utill.managers;
//
//import org.example.lab5.utill.ConsoleInput;
//import org.example.lab5.utill.commands.*;
//
//
//public class RuntimeManager {
//    private CollectionManager collectionManager = new CollectionManager();
//    private ConsoleInput input = new ConsoleInput();
//    private CommandManager commandManager;
////    private CommandManager commandManager;
//
//
////    public RuntimeManager(){
//////        this.commandManager = new CommandManager(
////////                new Add(input, collectionManager),
//////////                new AddIfMax(),
//////////                new AddIfMin(),
//////////                new AverageHealth(),
////////                new Info(collectionManager),
////////                new Clear(collectionManager),
////////                new Exit(),
////////                new History(commandManager),
////////                new Show(collectionManager)
////////        );
////    }
//
//    public void start(){
//
//            String command = input.next();
//            commandManager.execute(command);
//
//    }
//}
