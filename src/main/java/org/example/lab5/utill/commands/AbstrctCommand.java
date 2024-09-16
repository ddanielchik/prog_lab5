package org.example.lab5.utill.commands;

public abstract class AbstrctCommand {
    private String name;

    private String description;

    public AbstrctCommand(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void printCommand(){
        System.out.println( name + " " + description);
    }

    abstract public void execute();
}
