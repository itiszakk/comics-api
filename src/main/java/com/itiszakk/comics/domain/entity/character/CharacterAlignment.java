package com.itiszakk.comics.domain.entity.character;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum CharacterAlignment {
    HERO("hero"),
    ANTIHERO("antihero"),
    VILLAIN("villain");

    private final String type;

    CharacterAlignment(String type) {
        this.type = type;
    }

    public static CharacterAlignment getByType(String type) {
        return Arrays.stream(values())
                .filter(alignment -> alignment.getType().equals(type))
                .findFirst()
                .orElse(null);
    }

    public static List<String> getTypeList() {
        return Arrays.stream(values()).map(value -> value.type).toList();
    }
}