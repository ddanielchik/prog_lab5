package org.example.lab5.data.builder;

import org.example.lab5.data.Chapter;
import org.example.lab5.utill.ConsoleInput;

// параметром передали класс чаптер
/**
 * Класс ChapterBuild отвечает за создание объектов типа {@link Chapter}.
 * Он использует {@link ConsoleInput} для получения данных от пользователя.
 */
public class ChapterBuild extends Build<Chapter> {

    private ConsoleInput input;

    // создает шаблончики чаптеров
    /**
     * Конструктор класса ChapterBuild.
     *
     * @param input объект для ввода данных с консоли
     */
    public ChapterBuild(ConsoleInput input) {
        this.input = input;
    }

    /**
     * Создает новый объект {@link Chapter} на основе введенных пользователем данных.
     *
     * @return новый экземпляр {@link Chapter}
     */
    @Override
    public Chapter build() {
        return new Chapter(
                inputName(),
                inputParent(),
                inputMarinesCount(),
                inputWorld()
        );
    }

    /**
     * Запрашивает у пользователя имя главы.
     *
     * @return введенное имя главы
     */
    public String inputName() {
        System.out.println("input name: ");
        return input.next();
    }

    /**
     * Запрашивает у пользователя имя родительского легиона.
     *
     * @return введенное имя родительского легиона
     */
    public String inputParent() {
        System.out.println("input parent legion: ");
        return input.next();
    }

    /**
     * Запрашивает у пользователя количество морских пехотинцев.
     * Если введенное значение не является числом, запрашивает ввод повторно.
     *
     * @return введенное количество морских пехотинцев
     */
    public long inputMarinesCount() {
        while (true) {
            System.out.println("input count marines: ");
            try {
                return Long.parseLong(input.next());
            } catch (NumberFormatException e) {
                System.err.println("Вы ввели не числа, а какую-то хрень! Пробуйте снова");
            }
        }
    }

    /**
     * Запрашивает у пользователя имя мира.
     *
     * @return введенное имя мира
     */
    public String inputWorld() {
        System.out.println("input name world: ");
        return input.next();
    }
}