package org.example.lab5.data.builder;

import org.example.lab5.data.Chapter;
import org.example.lab5.utill.ConsoleInput;

// параметром передали класс чаптер
public class ChapterBuild extends Build<Chapter> {

    private ConsoleInput input;

    // создает шаблончики чаптеров
    public ChapterBuild(ConsoleInput input) {
        this.input = input;
    }

    @Override
    public Chapter build() {
        return new Chapter(
                inputName(),
                inputParent(),
                inputMarinesCount(),
                inputWorld()
        );
    }

    public String inputName() {
        System.out.println("input name: ");
        return input.next();
    }

    public String inputParent() {
        System.out.println("input parent legion: ");
        return input.next();
    }

    public Long inputMarinesCount() {
        while (true) {
                System.out.println("input count marines: ");
            try {
                return Long.parseLong(input.next());
            } catch (NumberFormatException e) {
                System.err.println("Вы ввели не числа, а какую-то хрень! Пробуйте снова");
            }
        }
    }

    public String inputWorld() {
        System.out.println("input name world: ");
        return input.next();
    }
}
