package org.example.lab5.data.builder;

import org.example.lab5.data.Coordinates;
import org.example.lab5.utill.ConsoleInput;

public class CoordinatesBuild extends Build<Coordinates> {

    private ConsoleInput input;

    public CoordinatesBuild(ConsoleInput input) {
        this.input = input;
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                inputX(),
                inputY()
        );
    }

    public double inputX() {
        while (true) {
                System.out.println("please input coordinate x type of double: ");
            try {
                return Double.parseDouble(input.next());
            } catch (NumberFormatException e) {
                System.err.println("Вы ввели не числа! Пробуйте снова");
            }
        }
    }

    public long inputY() {
        while (true) {
                System.out.println("please input coordinate y type of double: ");
            try {
                return Long.parseLong(input.next());
            } catch (NumberFormatException e) {
                System.err.println("Вы ввели не числа!!! Пробуйте снова");
            }
        }
    }
}
