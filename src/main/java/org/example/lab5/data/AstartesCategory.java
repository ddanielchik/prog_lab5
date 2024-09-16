package org.example.lab5.data;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum AstartesCategory {
    DREADNOUGHT,
    TACTICAL,
    LIBRARIAN,
    HELIX;

    @Override
    public String toString() {
        return name();
    }

    public static void printAll() {
        // лямбда выражения
        String result = String.join(", ", Arrays.stream(AstartesCategory.values()) // join объединяет с учетом особенностей(разделение запятой и пробелом)
                .map(Enum::toString)// переводим все значения в stroky
                .collect(Collectors.toList()));// собирает все в список
        System.out.println(result);
    }
}
