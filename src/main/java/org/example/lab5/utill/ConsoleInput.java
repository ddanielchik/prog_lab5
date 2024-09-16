package org.example.lab5.utill;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    // cmd + option + L    делает красива, ЗАПОМНИТЬ!!!!
    // next - метод, который позволяет работать нам через терминал(вводить что либо в консоль)
    // тут в будущем можно будет отлавливать comm+Z (прекращение ввода), commnd +D мяу полный...
    // и добавление null чкркз enter
    // тута можно использовать try catch
    public String next() throws NoSuchElementException {
        while (true) {
            try {
                String txt = scanner.nextLine().trim();
                if (txt.isEmpty()) {
                    System.err.println("Ты кого обмануть пытаешься?! ТЫ НИЧЕГО НЕ НАПИСАЛ!!!");
                } else {
                    return txt;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Вы нажали Ctrl+D. Ввод завершен.");
                System.exit(1);
                throw e; // Перебрасываем исключение, чтобы вызывающий код мог его обработать
            }
        }
    }
}
