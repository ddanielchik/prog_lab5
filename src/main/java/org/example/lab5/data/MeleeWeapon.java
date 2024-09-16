package org.example.lab5.data;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MeleeWeapon {
    CHAIN_SWORD,
    POWER_SWORD,
    LIGHTING_CLAW,
    POWER_BLADE,
    POWER_FIST;

    @Override
    public String toString() {
        return name();
    }

    public static void printAll() {
        String result = String.join(", ", Arrays.stream(MeleeWeapon.values())
                .map(Enum::toString)
                .collect(Collectors.toList()));
        System.out.println(result);
    }
}
