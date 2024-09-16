package org.example.lab5.data.builder;

import org.example.lab5.data.*;
import org.example.lab5.utill.ConsoleInput;

public class SpaceMarineBuild extends Build<SpaceMarine> {

    private ConsoleInput input;

    public SpaceMarineBuild(ConsoleInput input) {
        this.input = input;
    }

    @Override
    public SpaceMarine build() {
        return new SpaceMarine(
                inputName(),
                inputCoordinates(),
                inputHealth(),
                inputCategory(),
                inputWeapon(),
                inputMeleeWeapon(),
                inputChapter()
        );
    }

    public String inputName() {
        System.out.println("Введи имя для своей SpaceMarine  ");
        return input.next();
    }

    public Coordinates inputCoordinates() {
        System.out.println("input Coordinates \n-------------------------");
        CoordinatesBuild coordinatesBuild = new CoordinatesBuild(input);
        return coordinatesBuild.build();
    }

    public long inputHealth() {
        while (true) {
                System.out.println("input count health point!     ");
            try {
                return Long.parseLong(input.next());
            } catch (IllegalArgumentException e) {
                System.err.println("Чебурек, ты не то написал! Пробуй снова");
            }
        }
    }

    public AstartesCategory inputCategory() {
        while (true) {
        System.out.println("Chose AstartesCategory \n for example:");
        AstartesCategory.printAll();
            try {
                // vlueof- сравниваем с тем, что есть в инаме. || пробуем вводить строчку в КАПСЕ
                return AstartesCategory.valueOf(input.next().toUpperCase());
                // символы будут переволится в капс
            } catch (IllegalArgumentException exception) {
                System.err.println("Опять ерунду пишешь! Выбирай из того, что есть!!!");
            }
        }
    }

    public Weapon inputWeapon() {
        while (true) {
            System.out.println("choose some Weapon\n for example:");
            Weapon.printAll();
            try {
                return Weapon.valueOf(input.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Чебурек, ты не то написал! Пробуй снова:");
            }
        }
    }

    public MeleeWeapon inputMeleeWeapon() {
        while (true) {
            System.out.println("choose some MeleeWeapon\n for example: ");
            MeleeWeapon.printAll();
            try {
                return MeleeWeapon.valueOf(input.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.err.println("Чебурек, ты не то написал! Пробуй снова:");
            }
        }
    }

    public Chapter inputChapter() {
        System.out.println("input Chapter info \n-------------------------");
        ChapterBuild chapterBuild = new ChapterBuild(input);
        return chapterBuild.build();
    }
}

