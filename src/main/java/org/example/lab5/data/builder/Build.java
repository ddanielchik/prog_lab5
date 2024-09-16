package org.example.lab5.data.builder;

import org.example.lab5.utill.ConsoleInput;
// Билдер - паттерн проектирования (порождающий) который занимается созданием новых объектов
// более конкретный пример здеся:
// https://academy.mediasoft.team/article/porozhdayushie-patterny-proektirovaniya-dlya-kakikh-zadach-nuzhny-vidy-i-primery-realizacii/
// билдер параметризированного типа(чтобы класс мог работать с разными типами данными)

public abstract class Build <T>{
// абстр  метод
    abstract public T build();
}
