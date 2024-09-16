package org.example.lab5.data;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Weapon {
    BOLTGUN,
    PLASMA_GUN,
    GRENADE_LAUNCHER,
    MISSILE_LAUNCHER;

    @Override
    public String toString() {
        return name();
    }

    public static void printAll() {
        String result = String.join(", ", Arrays.stream(Weapon.values())
                .map(Enum::toString)
                .collect(Collectors.toList()));
        System.out.println(result);
    }
}
