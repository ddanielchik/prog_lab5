package org.example.lab5.utill.commands;

public class Exit extends AbstrctCommand{

    public Exit() {
        super("exit", "выход из программы");
    }

    @Override
    public void execute() {
        System.out.println("BYE BYE CHIAO CHIAO пока пока");
        System.exit(1);
    }
}
